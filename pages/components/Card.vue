<template>
  <div class="container">
    <div class="cardContainer" @click="clickHandle">
      <div class="imgContainer">
        <img :src="data.img" alt="">
      </div>
      <div class="briefContainer">
        <p class="title">{{data.name}}</p>
        <p class="brief">{{data.description}}</p>
      </div>
    </div>
    <Dialog
      title="使用方法"
      :visible.sync="dialogVisible"
    >
      <template slot="default">
        <h2>{{`${data.name}镜像库使用方法介绍`}}</h2>
        <div>{{data.instructions || '暂无使用方法，待补充'}}</div>
      </template>
    </Dialog>
  </div>
</template>

<script>
import {  Dialog  } from "element-ui";
export default {
  components: {
    Dialog
  },
  props:{
    data: {
      type: Object,
      default: ()=>{
        return {
          name: '',
          img: '',
          description: ''
        }
      }
    }
  },
  data() {
    return {
      dialogVisible: false
    }
  },
  methods:{
    clickHandle() {
      this.dialogVisible = true;
    }
  }
}
</script>

<style lang="less" scoped>
.container{
  display: inline-block;
  width: 300px;
  margin-bottom: 30px;
  box-shadow: 0 2px 12px 0 rgba(0,0,0,.1);
  border-radius: 4px;
  border: 1px solid #ebeef5;
  background-color: #fff;
  overflow: hidden;
  color: #303133;
  transition: .3s;
}
.cardContainer{
  cursor: pointer;
}
.imgContainer {
  width: 100px;
  height: 100px;
  margin-right: 10px;
  line-height: 100px;
  display: inline-block;
  img {
    width: 100px;
    vertical-align: middle;
  }
}
.briefContainer {
  width: 180px;
  display: inline-block;
  vertical-align: middle;
  .title {
    font-size: 24px;
  }
  .brief {
    font-size: 12px;
  }
}
</style>