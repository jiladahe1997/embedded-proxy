<template>
  <div>
    <div v-for='(item,idx) in announcement' :key='idx' class="container">
      <Popover
        placement="right"
        :title="item.title"
        width="200"
        trigger="click">
        <div slot="default">{{item.content}}</div>
        <span class="title" @click="clickHandle(item.id)" slot="reference">{{item.title}}</span>
      </Popover>
      <br/>
      <div class="time">{{item.time}}</div>
    </div>
  </div>
</template>

<script>
import dayjs from 'dayjs'
import {  Popover  } from "element-ui";

export default {
  components: {
    Popover,
  },
  data() {
    return {
      announcement: []
    }
  },
  async created() {
    const res = await this.$axios.get('/api/user/AncemtList');
    this.announcement = res.data.data;
  },
  methods:{
    async clickHandle(id){
      //查看公告详情
      //const res = this.$axios.get('')
      const res = await this.$axios.post('/api/user/AncemtDetl', {
        id
      })
      this.$set(this.announcement.find(v=>v.id===id),'content',res.data.data.content);
    }
  }
}
</script>

<style lang="less" scoped>
.container {
  .title {
    font-size: 14px;
    color: #315EFB;
    cursor: pointer;
  }
  .time {
    font-size: 12px;
    color: #666;
    text-align: right;
    position: relative;
    bottom: 13px;
    z-index: -1;
  }
}
</style>