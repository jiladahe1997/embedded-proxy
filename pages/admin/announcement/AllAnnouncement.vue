<template>
  <el-table :data="tableData" style="width: 100%">
    <el-table-column prop="id" label="编号"></el-table-column>
    <el-table-column prop="time" label="日期" ></el-table-column>
    <el-table-column prop="title" label="标题"></el-table-column>
  </el-table>
</template>

<script>
export default {  
  data() {
    return {
      tableData: [
        {
          date: "2016-05-02",
          name: "王小虎",
          address: "上海市普陀区金沙江路 1518 弄"
        }
      ]
    };
  },
  async created() {
    const res = await this.$axios.get('/api/admin/AncemtList')
    this.tableData = res.data.data;
  }
};
</script>