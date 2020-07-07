<template>
  <div>
    <h1>后台管理端</h1>
    <div class="container">
      <el-menu class="menu" :router="true" ref="menu">
        <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span>公告管理</span>
            </template>         
            <el-menu-item index="/announcement/all">公告查看及删除</el-menu-item>
            <el-menu-item index="/announcement/add">新增公告</el-menu-item>
          </el-submenu>
      </el-menu>
      <div class="content">
        <router-view></router-view>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  mounted() {
    this.manualSetMenuActive(window.location.pathname.replace("/admin",''))
    this.$router.beforeEach((to, from, next) =>{
        this.manualSetMenuActive(to.path)
        next()
    })
  },
  methods:{
    manualSetMenuActive(path) {
      this.$refs.menu.defaultActive = path
    }
  }
}
</script>

<style lang="less" scoped>
.menu {
  width: 250px;
}
.container{
  display: flex;
  .content {
    flex-grow: 1;
    padding: 20px;
  }
}
</style>