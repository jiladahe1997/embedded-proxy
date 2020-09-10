<template>
  <el-form ref="form" :model="form" label-width="80px">
    <el-form-item label="公告标题" prop="title" :rules="[
      { required: true, message: '公告标题不能为空'},
    ]">
      <el-input v-model="form.title"></el-input>
    </el-form-item>
    <el-form-item label="公告类型" prop="type" :rules="[
      { required: true, message: '公告类型不能为空'},
    ]">
      <el-select v-model="form.type" placeholder="请选择公告类型">
        <el-option label="一般公告" value="normal"></el-option>
        <el-option label="重要公告" value="important"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="公告内容" prop="content" :rules="[
      { required: true, message: '公告内容不能为空'},
    ]">
      <el-input type="textarea" v-model="form.content"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit">立即创建</el-button>
      <el-button>取消</el-button>
    </el-form-item>
  </el-form>
</template> 

<script>
  export default {
    data() {
      return {
        form: {
          title: '',
          type: '',
          content: ''
        }
      }
    },
    methods: {
      onSubmit() {
        this.$refs.form.validate(async(valid) => {
          if (valid) {
            const res = await this.$axios.post("/api/admin/AddAncemt",this.form)
            if(res.data.code == '0') {
              this.$message({
                showClose: true,
                message: '提交成功，5s后自动刷新页面',
                type: 'success'
              });
              setTimeout(()=>{
                this.$router.push({ path: '/announcement/all'})
              },5000)
            }else {
              this.$message({
                showClose: true,
                message: `提交失败，错误信息：${res.data}`,
                type: 'error'
              });
            }
          } else {
            return false;
          }
        });
      }
    }
  }
</script>