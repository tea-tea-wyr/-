<template>
  <div class="app-container home">
    <el-row :gutter="20">
      <el-col :sm="24" :lg="24">


        <hr />
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :sm="24" :lg="12" style="padding-left: 20px">
        <h2>校园活动后台管理系统</h2>
        <h4>主要功能</h4>
        <p>
          1. 对活动组织方与学生的信息进行增删改查，统计校内活动组织方活动组织的具体情况
        </p>
        <p>
          2. 对用户的权限进行管理与控制
        </p>
<!--        <p>-->
<!--          3. 对活动方的活动进行审核，接受学生对活动方的举报-->
<!--        </p>-->
        <p>
          3. 对学生参加的活动进行统计与计分
        </p>
        <p>
          4. 良好的人机交互界面
        </p>
        <p>
          5. 便捷的添加、修改、查询数据功能
        </p>
        <p>
          6. 系统管理、组织管理、活动管理、学生管理等
        </p>
        <p>
          <el-button
            type="primary"
            size="mini"
            icon="el-icon-cloudy"
            plain
            @click="goTarget('https://github.com/tea-tea-wyr/Background-management-system-of-campus-activities/tree/master')"
            >访问码云</el-button
          >
        </p>
      </el-col>

      <el-col :sm="24" :lg="12" style="padding-left: 50px">
        <el-row>
          <el-col :span="12">
            <h2>技术选型</h2>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="6">
            <h4>后端技术</h4>
            <ul>
              <li>SpringBoot</li>
              <li>Spring Security</li>
              <li>JWT</li>
              <li>MyBatis</li>
              <li>Druid</li>
              <li>Fastjson</li>
              <li>...</li>
            </ul>
          </el-col>
          <el-col :span="6">
            <h4>前端技术</h4>
            <ul>
              <li>Vue</li>
              <li>Vuex</li>
              <li>Element-ui</li>
              <li>Axios</li>
              <li>Sass</li>
              <li>Quill</li>
              <li>...</li>
            </ul>
          </el-col>
        </el-row>
      </el-col>
    </el-row>
    <el-divider />
    <el-row :gutter="20">
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>管理员数量</span>
          </div>
          <el-collapse accordion>
            <el-collapse-item title="v3.3.0 - 2020-12-14">
              <ol>
                <li>新增缓存监控功能</li>
                <li>支持主题风格配置</li>
                <li>修复多级菜单之间切换无法缓存的问题</li>
                <li>多级菜单自动配置组件</li>
                <li>代码生成预览支持高亮显示</li>
                <li>支持Get请求映射Params参数</li>
                <li>删除用户和角色解绑关联</li>
                <li>去除用户手机邮箱部门必填验证</li>
                <li>Excel支持注解align对齐方式</li>
                <li>Excel支持导入Boolean型数据</li>
                <li>优化头像样式，鼠标移入悬停遮罩</li>
                <li>代码生成预览提供滚动机制</li>
                <li>代码生成删除多余的数字float类型</li>
                <li>修正转换字符串的目标字符集属性</li>
                <li>回显数据字典防止空值报错</li>
                <li>日志记录增加过滤多文件场景</li>
                <li>修改缓存Set方法可能导致嵌套的问题</li>
                <li>移除前端一些多余的依赖</li>
                <li>防止安全扫描YUI出现的风险提示</li>
                <li>修改node-sass为dart-sass</li>
                <li>升级SpringBoot到最新版本2.1.18</li>
                <li>升级poi到最新版本4.1.2</li>
                <li>升级oshi到最新版本v5.3.6</li>
                <li>升级bitwalker到最新版本1.21</li>
                <li>升级axios到最新版本0.21.0</li>
                <li>升级element-ui到最新版本2.14.1</li>
                <li>升级vue到最新版本2.6.12</li>
                <li>升级vuex到最新版本3.6.0</li>
                <li>升级vue-cli到版本4.5.9</li>
                <li>升级vue-router到最新版本3.4.9</li>
                <li>升级vue-cli到最新版本4.4.6</li>
                <li>升级vue-cropper到最新版本0.5.5</li>
                <li>升级clipboard到最新版本2.0.6</li>
                <li>升级core-js到最新版本3.8.1</li>
                <li>升级echarts到最新版本4.9.0</li>
                <li>升级file-saver到最新版本2.0.4</li>
                <li>升级fuse.js到最新版本6.4.3</li>
                <li>升级js-beautify到最新版本1.13.0</li>
                <li>升级js-cookie到最新版本2.2.1</li>
                <li>升级path-to-regexp到最新版本6.2.0</li>
                <li>升级quill到最新版本1.3.7</li>
                <li>升级screenfull到最新版本5.0.2</li>
                <li>升级sortablejs到最新版本1.10.2</li>
                <li>升级vuedraggable到最新版本2.24.3</li>
                <li>升级chalk到最新版本4.1.0</li>
                <li>升级eslint到最新版本7.15.0</li>
                <li>升级eslint-plugin-vue到最新版本7.2.0</li>
                <li>升级lint-staged到最新版本10.5.3</li>
                <li>升级runjs到最新版本4.4.2</li>
                <li>升级sass-loader到最新版本10.1.0</li>
                <li>升级script-ext-html-webpack-plugin到最新版本2.1.5</li>
                <li>升级svg-sprite-loader到最新版本5.1.1</li>
                <li>升级vue-template-compiler到最新版本2.6.12</li>
                <li>其他细节优化</li>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v3.2.1 - 2020-11-18"></el-collapse-item>
            <el-collapse-item title="v3.2.0 - 2020-10-10"></el-collapse-item>

            <el-collapse-item title="v3.1.0 - 2020-08-13"></el-collapse-item>

            <el-collapse-item title="v3.0.0 - 2020-07-20"></el-collapse-item>

            <el-collapse-item title="v2.3.0 - 2020-06-01"></el-collapse-item>

            <el-collapse-item title="v2.2.0 - 2020-03-18"></el-collapse-item>

            <el-collapse-item title="v2.1.0 - 2020-02-24"></el-collapse-item>

            <el-collapse-item title="v2.0.0 - 2019-12-02"></el-collapse-item>
            <el-collapse-item title="v1.1.0 - 2019-11-11"></el-collapse-item>
            <el-collapse-item title="v1.0.0 - 2019-10-08"></el-collapse-item>
          </el-collapse>
        </el-card>
      </el-col>

    </el-row>
  </div>
</template>

<script>
export default {
  name: "index",
  data() {
    return {
      // 版本号
      version: "3.3.0",
    };
  },
  methods: {
    goTarget(href) {
      window.open(href, "_blank");
    },
  },
};
</script>

<style scoped lang="scss">
.home {
  blockquote {
    padding: 10px 20px;
    margin: 0 0 20px;
    font-size: 17.5px;
    border-left: 5px solid #eee;
  }
  hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid #eee;
  }
  .col-item {
    margin-bottom: 20px;
  }

  ul {
    padding: 0;
    margin: 0;
  }

  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 13px;
  color: #676a6c;
  overflow-x: hidden;

  ul {
    list-style-type: none;
  }

  h4 {
    margin-top: 0px;
  }

  h2 {
    margin-top: 10px;
    font-size: 26px;
    font-weight: 100;
  }

  p {
    margin-top: 10px;

    b {
      font-weight: 700;
    }
  }

  .update-log {
    ol {
      display: block;
      list-style-type: decimal;
      margin-block-start: 1em;
      margin-block-end: 1em;
      margin-inline-start: 0;
      margin-inline-end: 0;
      padding-inline-start: 40px;
    }
  }
}
</style>

