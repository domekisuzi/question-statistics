<template>
    <el-container>
      <el-header>660题管理系统</el-header>
      <el-main>
        <QuestionTable />
      </el-main>
    </el-container>
</template>

<script>
import { defineComponent } from 'vue';
import QuestionTable from './components/QuestionTable.vue';

export default defineComponent({
  name: 'App',
  components: {
    QuestionTable
  }
});
</script>

<style scoped>
body {
  font-family: 'Arial', sans-serif;
  margin: 0;
  padding: 0;
}
.el-container{
  height: 100%;
  width: 100vw;

}
.el-main{
  height: 80%;
  width: 100%;
}
.el-header{
  height: 20%;
  width: 100%;
}

</style>
