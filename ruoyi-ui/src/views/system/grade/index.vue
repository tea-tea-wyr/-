<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="学号" prop="stuid">
        <el-input
          v-model="queryParams.stuid"
          placeholder="请输入学号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="活动号" prop="actid">
        <el-input
          v-model="queryParams.actid"
          placeholder="请输入活动号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!-- <el-form-item label="记录时长" prop="hour">
        <el-input
          v-model="queryParams.hour"
          placeholder="请输入记录时长"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="活动分数" prop="grade">
        <el-input
          v-model="queryParams.grade"
          placeholder="请输入活动分数"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item>
        <el-button type="cyan" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:grade:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:grade:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:grade:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:grade:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="gradeList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="学号" align="center" prop="stuid" />
       <el-table-column label="姓名" align="center" prop="aysStu.stuName" />
       <el-table-column label="活动号" align="center" prop="actid" />
      <el-table-column label="活动名称" align="center" prop="aysAct.aname" />
      <el-table-column label="记录时长" align="center" prop="aysAct.ahour" />
      <el-table-column label="活动分数" align="center" prop="aysAct.agrade" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:grade:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:grade:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改学生活动成绩对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
         <el-form-item label="学号" prop="stuid">
          <el-input v-model="form.stuid" placeholder="请输入学号" />
        </el-form-item>
         <el-form-item label="活动号" prop="actid">
          <el-input v-model="form.actid" placeholder="请输入活动号" />
        </el-form-item>
        <!-- <el-form-item label="记录时长" prop="hour">
          <el-input v-model="form.hour" placeholder="请输入记录时长" />
        </el-form-item>
        <el-form-item label="活动分数" prop="grade">
          <el-input v-model="form.grade" placeholder="请输入活动分数" />
        </el-form-item> -->
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listGrade, getGrade, delGrade, addGrade, updateGrade, exportGrade } from "@/api/system/grade";
import {listAct,getAct} from "@/api/system/act";
import {getStu} from "@/api/system/stu";

export default {
  name: "Grade",
  components: {
  },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 学生活动成绩表格数据
      gradeList: [],
      actList:[],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      updateFlag:false,
      stuExist:false,
      actExist:false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        stuid:null,
        actid:null,
        hour: null,
        grade: null
      },
      actParams: {
          pageNum: 1,
          pageSize: 10,
          actid:null
        },
        delParams:{
          stuId:null,
          actId:null
        },
      // 表单参数
      form: {},
      data_stu:{},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询学生活动成绩列表 */
    getList() {
      this.loading = true;
      listGrade(this.queryParams).then(response => {
        this.gradeList = response.rows;
        
        this.total = response.total;
        this.loading = false;
        console.log(this.gradeList);
        
        
//         this.gradeList.filter((item,i) => {
//     // i 表示第几次循环
//     // item 表示当前循环中的数据
    
//     this.actParams.actid=item.actid;
//     console.log("参数:"+this.actParams.actid);
//    listAct(this.actParams, this.dateRange).then(response => {
//           this.actList = response.rows;
//           console.log(this.actList);
//           item.aname=this.actList.aname;
//           console.log("actName:"+this.actList.aname);
//           console.log("name: "+item.aname);
//           this.total = response.total;
//           this.loading = false;
          
//         });
// })
// console.log(this.gradeList);
        

      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        stuid: null,
        actid: null,
        hour: null,
        grade: null
      };
      this.resetForm("form");
    },
    ExistQuery(stuid,actid){
      
      getStu(stuid).then(response => {
       this.data_stu=response.data;
       
        console.log("学生撒旦发射点"+this.data_stu);
      if(this.data_stu!=undefined)
        this.stuExist=true;
       
      });

      getAct(actid).then(response=>{
         if(response.data!=undefined)
        this.actExist=true;
      });

    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.stuid)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加学生活动成绩";
      
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const stuid = row.stuid || this.ids
      getGrade(stuid).then(response => {
        this.updateFlag=true;
        this.form = response.data;
        this.open = true;
        this.title = "修改学生活动成绩";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          console.log(this.form);
          if (this.updateFlag==true) {
            updateGrade(this.form).then(response => {
              console.log("修改");
              console.log(this.form);

              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
              this.updateFlag=false;
            });
          } else {
            // 验证数据库中是否有此学号
            this.ExistQuery(this.form.stuid,this.form.actid);
            if(this.stuExist==true && this.actExist==true){
            addGrade(this.form).then(response => {
              console.log("新增"+this.form);
              this.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
            }
            else if(this.stuExist==false && this.actExist==true){
              this.msgSuccess("该学生不存在，请重新填写学号");
              this.reset();
            }
            else if(this.stuExist==true&&this.actExist==false){
              this.msgSuccess("该活动不存在，请重新填写活动号");
              this.reset();
            }
            else{
              this.msgSuccess("该学生与活动都不存在不存在，请重新填写");
              this.reset();
            }
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      // const stuid=row.stuid;
      // const actid=row.actid;
      var _this=this;
      // _this.delParams.stuId=stuid;
      // _this.delParams.actId=actid;
      // console.log(_this.delParams);
      this.reset();
      const stuid = row.stuid || this.ids
      getGrade(stuid).then(response => {
        _this.form = response.data;
      });
      console.log("dkfjfkj"+_this.form.stuid);
      const stuids = row.stuid || this.ids;
      this.$confirm('是否确认删除学生号为"' + stuids+ '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          // console.log(_this.delParams.stuId)
          return delGrade(_this.form);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有学生活动成绩数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportGrade(queryParams);
        }).then(response => {
          this.download(response.msg);
        })
    }
  }
};
</script>
