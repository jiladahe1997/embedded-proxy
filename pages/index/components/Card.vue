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
      <div class="syncResult">
        <p>
          {{`上次同步时间:${lastUpdateTime} `}}
        </p>
        <p>
          {{`同步结果:`}}<span :style="{color: lastResult === '暂无数据'? 'grey' : 
            lastResult === '失败' ? 'red':'green'}">{{lastResult}}</span>
        </p>
      </div>
    </div>
    <Dialog
      title="使用方法"
      :visible.sync="dialogVisible"
      @open="openHandle"
    >
      <template slot="default">
        <h2>{{`${data.name}镜像库使用方法介绍`}}</h2>
        <div v-html="instructions || '暂无使用方法，待补充'"></div>
      </template>
    </Dialog>
  </div>
</template>

<script>
import {  Dialog  } from "element-ui";
import Qs from 'qs'
import dayjs from 'dayjs'
import marked from 'marked'

const COMMON_URL = "https://download.embeddedproxy.cn/mirrorFile/"
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
          description: '',
          handleName: '',
          instructionsFileName: ''
        }
      }
    }
  },
  data() {
    return {
      dialogVisible: false,
      lastUpdateTime: '暂无数据',
      lastResult:'暂无数据',
      instructions: ''
    }
  },
  async created() {
    if(this.data.handleName) {
      const res = await this.$axios.get('/api/schedule/result',{
        params: {
          handleName: [this.data.handleName]
        },
        paramsSerializer: function(params) {
          return Qs.stringify(params, {arrayFormat: 'repeat'})
        },
      })
      this.lastUpdateTime = dayjs(res.data.data[0].triggerTime).format("YYYY-MM-DD HH:mm:ss")
      this.lastResult = res.data.data[0].success ? "成功" : "失败"
    }

    if (!this.data.instructionsFileName) return ''
    import(`@docs/${this.data.instructionsFileName}.md`).then(async (module)=>{
      this.instructions = marked(module.default)
    })

  },
  methods:{
    clickHandle() {
      this.dialogVisible = true;
    },
    async openHandle() {
      const downloadUrl = await this.$axios.get('/api/SyncConfig/keil')
      this.$nextTick(()=>{
        window.document.querySelector("#Keil-installer").href = COMMON_URL + downloadUrl.data.data.find(v=>v.fileName==="MDK529.EXE").fileName
        window.document.querySelector("#Keil-installer").target  = "__blank"
        window.document.querySelector("#Keil-installer").innerHTML  = downloadUrl.data.data.find(v=>v.fileName==="MDK529.EXE").fileName
        const packListNode =  window.document.querySelector("#Keil-packs")
        const packList = downloadUrl.data.data.filter(v=>v.fileName!=="MDK529.EXE")
        packListNode.innerHTML = ''
        packList.forEach(v=>{
          const li = window.document.createElement('li')
          const a = window.document.createElement('a')
          a.innerHTML=v.fileName
          a.target = "__blank"
          a.href = COMMON_URL+v.fileName
          li.append(a)
          packListNode.append(li)
        })
      })
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
  &:hover{
    box-shadow: 0 5px 25px rgba(0,0,0,0.5);
  }
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
  text-align: center;
  img {
    width: 75px;
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
.syncResult {
  text-align: right;
  font-size: 10px;
}
</style>