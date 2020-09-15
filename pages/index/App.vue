<template>
  <div class="app">
    <Header></Header>
    <div class="content">
      <div class='mirrorContainer'>
        <h2>镜像列表</h2>
        <div class="content">
          <Card class='card' v-for="(item,index) in list" :key='index' :data="item"></Card>
        </div>
      </div>
      <div class="help">
        <h3>使用须知</h3>
        <div>
          本站是作者在从事嵌入式软件开发相关工作中，发现各种软件下载很不方便，故建立此站，提供部分软件的快速下载。<br/>
          本网站只负责搬运软件，不对软件做任何修改，所有软件均提供源下载地址，下载完成后请自行校验文件MD5.<br/>
          <br/>
          如有侵权请联系删除，联系方式：jiladahe1997@gmail.com
        </div>
        <hr style="FILTER:alpha(opacity=100,finishopacity=0,style=3);margin: 40px 0" width="80%" color=#CDCFD1 SIZE=3>
        <h3 class="announcement">公告</h3>
        <Announcement />
        <hr style="FILTER:alpha(opacity=100,finishopacity=0,style=3);margin: 40px 0" width="80%" color=#CDCFD1 SIZE=3>
        <h3>赞助</h3> 
        <div>
          开发和维护本站耗费了我不少的休息时间，如果你觉得本站对你有所帮助，请赞助我喝杯瑞幸咖啡（非广告
          <br>
          <div style="text-align:center">
            <img src="../public/appreciate_QR_code.png" alt="" width="200">
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Header from './components/Header.vue'
import Card from './components/Card.vue'
import Announcement from './components/Announcement.vue'

export default {
  name: 'App',
  components: {
    Header,
    Card,
    Announcement
  },
  data() {
    return {
      list: []
    }
  },
  async created(){
    const res = await this.$axios.get('/api/index/config')
    this.list = res.data.data.list
  }
}
</script>

<style lang="less" scoped>
.app {
  width: 1366px;
  margin: auto;
}
.content {
  padding-top: 36px;
  .mirrorContainer{
    display: inline-block;
    width: 71%;
    .content {
      background-color: #f5f5f5;
      padding: 15px 10px;
      .card {
        margin-right: 20px;
      }
      .card:nth-child(3n) {
        margin-right: 0px;
      }
    }
  }
}
.help {
  > div{
    font-size: 15px;
  }
  .announcement{
  }
  display: inline-block;
  width: 29%;
  vertical-align: top;
  padding: 50px 0 0 10px;
  box-sizing: border-box;
}
</style>
