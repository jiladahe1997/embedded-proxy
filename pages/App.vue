<template>
  <div class="app">
    <Header></Header>
    <div class='mirrorContainer'>
      <h2>镜像列表</h2>
      <div class="content">
        <Card class='card' v-for="(item,index) in list" :key='index' :data="item"></Card>
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
.mirrorContainer{
  margin-top: 112px;
  .content {
    background-color: #f5f5f5;
    padding: 20px 20px;
    .card {
      margin-right: 39px;
    }
    .card:nth-child(4n) {
      margin-right: 0px;
    }
  }
}
</style>
