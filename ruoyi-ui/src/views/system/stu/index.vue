<template>
  <div class="app-container">
      <el-row :gutter="20">
      <!--部门数据-->
      <el-col :span="4" :xs="24">
        <div class="head-container">
          <el-input
            v-model="deptName"
            placeholder="请输入部门名称"
            clearable
            size="small"
            prefix-icon="el-icon-search"
            style="margin-bottom: 20px"
          />
        </div>
        <div class="head-container">
          <el-tree
            :data="deptOptions"
            :props="defaultProps"
            :expand-on-click-node="false"
            :filter-node-method="filterNode"
            ref="tree"
            default-expand-all
            @node-click="handleNodeClick"
          />
        </div>
      </el-col>
      <!--用户数据-->
      <el-col :span="20" :xs="24">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="学号" prop="stuId">
        <el-input
          v-model="queryParams.stuId"
          placeholder="请输入学号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="姓名" prop="stuName">
        <el-input
          v-model="queryParams.stuName"
          placeholder="请输入姓名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学历" prop="sdegree">
        <el-input
          v-model="queryParams.sdegree"
          placeholder="请输入学历"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学院" prop="sacademy">
        <el-input
          v-model="queryParams.sacademy"
          placeholder="请输入学院"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="班级" prop="sclass">
        <el-input
          v-model="queryParams.sclass"
          placeholder="请输入班级"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="手机号" prop="snum">
        <el-input
          v-model="queryParams.snum"
          placeholder="请输入手机号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="邮箱" prop="semail">
        <el-input
          v-model="queryParams.semail"
          placeholder="请输入邮箱"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="性别" prop="sgender">
        <el-input
          v-model="queryParams.sgender"
          placeholder="请输入性别"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="状态" prop="sstatus">
        <el-select v-model="queryParams.sstatus" placeholder="请选择状态" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="状态" prop="status">
            <el-select
              v-model="queryParams.status"
              placeholder="用户状态"
              clearable
              size="small"
              style="width: 240px"
            >
              <el-option
                v-for="dict in statusOptions"
                :key="dict.dictValue"
                :label="dict.dictLabel"
                :value="dict.dictValue"
              />
            </el-select>
          </el-form-item>
      <el-form-item label="职务" prop="sjob">
        <el-input
          v-model="queryParams.sjob"
          placeholder="请输入职务"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
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
          v-hasPermi="['system:stu:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:stu:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:stu:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:stu:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="stuList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="学号" align="center" prop="stuId" />
      <el-table-column label="密码" align="center" prop="spwd" />
      <el-table-column label="姓名" align="center" prop="stuName" />
      <el-table-column label="部门" align="center" prop="dept.deptName" />
      <el-table-column label="学历" align="center" prop="sdegree" />
      <el-table-column label="学院" align="center" prop="sacademy" />
      <el-table-column label="班级" align="center" prop="sclass" />
      <el-table-column label="手机号" align="center" prop="snum" />
      <el-table-column label="邮箱" align="center" prop="semail" />
      <el-table-column label="性别" align="center" prop="sgender" />
      <el-table-column label="状态" align="center" prop="sstatus" />
      <el-table-column label="职务" align="center" prop="sjob" />
      <el-table-column label="用户角色" align="center" prop="srole" />
      <el-table-column label="备注" align="center" prop="sremark" />
      <el-table-column label="最后登录IP" align="center" prop="loginip" />
      <el-table-column label="最后登录时间" align="center" prop="logintime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.logintime, '{y}-{m}-{d} {h}:{m}{s}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:stu:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:stu:remove']"
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
     </el-col>
    </el-row>

    <!-- 添加或修改学生对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
         <el-form-item label="学号" prop="stuId">
          <el-input v-model="form.stuId" placeholder="请输入学号" />
        </el-form-item>
        <el-form-item label="密码" prop="spwd">
          <el-input v-model="form.spwd" placeholder="请输入密码" />
        </el-form-item>
        <el-form-item label="姓名" prop="stuName">
          <el-input v-model="form.stuName" placeholder="请输入姓名" />
        </el-form-item>
       
        <el-form-item label="归属部门" prop="deptId">
            <treeselect v-model="form.deptId" :options="deptOptions" :show-count="true" placeholder="请选择归属部门" />
        </el-form-item>
         

        <el-form-item label="学历" prop="sdegree">
          <el-input v-model="form.sdegree" placeholder="请输入学历" />
        </el-form-item>
        <el-form-item label="学院" prop="sacademy">
          <el-input v-model="form.sacademy" placeholder="请输入学院" />
        </el-form-item>
        <el-form-item label="班级" prop="sclass">
          <el-input v-model="form.sclass" placeholder="请输入班级" />
        </el-form-item>
        <el-form-item label="手机号" prop="snum">
          <el-input v-model="form.snum" placeholder="请输入手机号" />
        </el-form-item>
        <el-form-item label="邮箱" prop="semail">
          <el-input v-model="form.semail" placeholder="请输入邮箱" />
        </el-form-item>
        <el-form-item label="性别" prop="sgender">
          <el-input v-model="form.sgender" placeholder="请输入性别" />
        </el-form-item>
        <el-form-item label="状态">
          <el-radio-group v-model="form.sstatus">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="职务" prop="sjob">
          <el-input v-model="form.sjob" placeholder="请输入职务" />
        </el-form-item>
        <el-form-item label="用户角色" prop="srole">
          <el-input v-model="form.srole" placeholder="请输入用户角色" />
        </el-form-item>
        <el-form-item label="备注" prop="sremark">
          <el-input v-model="form.sremark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="最后登录IP" prop="loginip">
          <el-input v-model="form.loginip" placeholder="请输入最后登录IP" />
        </el-form-item>
        <el-form-item label="最后登录时间" prop="logintime">
          <el-date-picker clearable size="small"
            v-model="form.logintime"
            type="date"
            value-format="yyyy-MM-dd hh:mm:ss"
            placeholder="选择最后登录时间">
          </el-date-picker>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listStu, getStu, delStu, addStu, updateStu, exportStu } from "@/api/system/stu";
import { getToken } from "@/utils/auth";
import { treeselect } from "@/api/system/dept";
import Treeselect from "@riophae/vue-treeselect";
import "@riophae/vue-treeselect/dist/vue-treeselect.css";

export default {
  name: "Stu",
  components: { Treeselect },
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
      // 学生表格数据
      stuList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 部门树选项
      deptOptions: undefined,
       // 部门名称
      deptName: undefined,
      // 状态数据字典
      statusOptions: [],
      // 性别状态字典
      sexOptions: [],
      // 岗位选项
      postOptions: [],
      // 角色选项
      roleOptions: [],
      updateFlag: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        stuId:null,
        spwd: null,
        deptId:null,
        stuName: null,
        sdegree: null,
        sacademy: null,
        sclass: null,
        snum: null,
        semail: null,
        sgender: null,
        sstatus: null,
        sjob: null,
        srole: null,
        sremark: null,
        loginip: null,
        logintime: null
      },
      // 表单参数
      form: {},
      defaultProps: {
        children: "children",
        label: "label"
      },
      // 表单校验
      rules: {
        stuId: [
          { required: true, message: "学号不能为空", trigger: "blur" }
        ],
        spwd: [
          { required: true, message: "密码不能为空", trigger: "blur" }
        ],
        stuName: [
          { required: true, message: "姓名不能为空", trigger: "blur" }
        ],
        sacademy: [
          { required: true, message: "学院不能为空", trigger: "blur" }
        ],
        sclass: [
          { required: true, message: "班级不能为空", trigger: "blur" }
        ],
      }
    };
  },
    watch: {
    // 根据名称筛选部门树
    deptName(val) {
      this.$refs.tree.filter(val);
    }
  },
  created() {
    this.getList();
    this.getTreeselect();
    this.getDicts("sys_normal_disable").then(response => {
      this.statusOptions = response.data;
    });
    this.getDicts("sys_user_sex").then(response => {
      this.sexOptions = response.data;
    });
    this.getConfigKey("sys.user.initPassword").then(response => {
      this.initPassword = response.msg;
    });

  },
  methods: {
    /** 查询学生列表 */
    getList() {
      this.loading = true;
      listStu(this.queryParams).then(response => {
        this.stuList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
      /** 查询部门下拉树结构 */
    getTreeselect() {
      treeselect().then(response => {
        this.deptOptions = response.data;
      });
    },
    // 筛选节点
    filterNode(value, data) {
      if (!value) return true;
      return data.label.indexOf(value) !== -1;
    },
    // 节点单击事件
    handleNodeClick(data) {
      this.queryParams.deptId = data.id;
      this.getList();
    },

    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
      this.updateFlag=false;
    },
    // 表单重置
    reset() {
      
      this.form = {
        stuId: undefined,
        spwd: undefined,
        stuName:undefined,
        deptId: undefined,
        sdegree: undefined,
        sacademy: undefined,
        sclass: undefined,
        snum: undefined,
        semail: undefined,
        sgender: undefined,
        sstatus: undefined,
        sjob: undefined,
        srole: undefined,
        sremark: undefined,
        loginip: undefined,
        logintime: undefined
        
      };
      // this.form = {
      //   stuId: null,
      //   spwd: '789',
      //   stuName: 'mengzai',
      //   deptId: '100',
      //   sdegree: '0',
      //   sacademy: '信息学院',
      //   sclass: '计科1702',
      //   snum: '18801245138',
      //   semail: '4101842',
      //   sgender: '0',
      //   sstatus: "0",
      //   sjob: '撒旦解放和',
      //   srole: '数据都是废话',
      //   sremark: '史蒂夫为福建',
      //   loginip: null,
      //   logintime: null
        
      // };
      this.resetForm("form");
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
      this.ids = selection.map(item => item.stuId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加学生";
      this.updateFlag=false;
      console.log(this.updateFlag);
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const stuId = row.stuId || this.ids
      getStu(stuId).then(response => {
        this.updateFlag = true;
        this.form = response.data;
        this.open = true;
        this.title = "修改学生";
        console.log(this.updateFlag);
      });
    },
    /** 提交按钮 */
    submitForm() {
        console.log(this.form.stuId);
      this.$refs["form"].validate(valid => {
        if (valid) {
            console.log("valid成功！")
            console.log(this.form);
          if (this.updateFlag==true) {
            console.log(this.updateFlag);
            console.log("111");
            updateStu(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
              this.updateFlag=false;
            });
          } else {
            addStu(this.form).then(response => {
              console.log(this.updateFlag);
              console.log("000");
              this.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const stuIds = row.stuId || this.ids;
      this.$confirm('是否确认删除学生编号为"' + stuIds + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delStu(stuIds);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
    },
    /** 导出按钮操作    */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有学生数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportStu(queryParams);
        }).then(response => {
          this.download(response.msg);
        })
    }
  }
};
</script>
