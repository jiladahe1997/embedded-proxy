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
        <h3>公告</h3>
        <h3>使用帮助</h3>
      </div>
    </div>
  </div>
</template>

<script>
import Header from './components/Header.vue'
import Card from './components/Card.vue'


export default {
  name: 'App',
  components: {
    Header,
    Card
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
  padding-top: 112px;
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
  display: inline-block;
  width: 29%;
  vertical-align: top;
}
</style>
