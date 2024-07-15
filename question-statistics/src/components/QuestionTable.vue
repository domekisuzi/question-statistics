<template>
  <div>
    <el-button plain @click="dialogVisible = true">添加题目</el-button>

    <el-dialog v-model="dialogVisible" title="添加题目" width="500">
      <el-form :model="newQuestion">
        <el-form-item label="Correct">
          <el-checkbox v-model="newQuestion.isCorrect"></el-checkbox>
        </el-form-item>
        <el-form-item label="Wrong">
          <el-checkbox v-model="newQuestion.isWrong"></el-checkbox>
        </el-form-item>
        <el-form-item label="Guessed">
          <el-checkbox v-model="newQuestion.isGuess"></el-checkbox>
        </el-form-item>
                <el-form-item label="Completely Unknown">
                  <el-checkbox v-model="newQuestion.isUnknown"></el-checkbox>
                </el-form-item>
        <el-form-item label="Remarks">
          <el-input v-model="newQuestion.remarks"></el-input>
        </el-form-item>
        <el-form-item label="Knowledge Type">
          <el-input v-model="newQuestion.knowledgeType"></el-input>
        </el-form-item>
        <el-form-item label="Special Points">
          <el-input v-model="newQuestion.specialPoints"></el-input>
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button @click="dialogVisible = false">取消</el-button>
          <el-button type="primary" @click="addQuestion">确认</el-button>
        </div>
      </template>
    </el-dialog>

    <el-table :data="questions" border style="width: 80%" @cell-click="editQuestion">
      <el-table-column prop="id" label="题号" width="50"></el-table-column>
      <el-table-column prop="isCorrect" label="对"></el-table-column>
      <el-table-column prop="isWrong" label="错"></el-table-column>
      <el-table-column prop="isGuess" label="猜"></el-table-column>
            <el-table-column prop="isUnknown" label="完全不会"></el-table-column>
      <el-table-column prop="remarks" label="备注"></el-table-column>
      <el-table-column prop="knowledgeType" label="知识点类型"></el-table-column>
      <el-table-column prop="specialPoints" label="特殊点"></el-table-column>
<!--      <el-table-column fixed="right" label="操作" width="120">-->
<!--        <template #default="scope">-->
<!--          <el-button @click="deleteQuestion(scope.row.id)" type="text" size="small">删除</el-button>-->
<!--        </template>-->
<!--      </el-table-column>-->
    </el-table>

    <el-pagination
        @current-change="handlePageChange"
        :current-page="currentPage"
        :page-size="pageSize"
        layout="prev, pager, next"
        :total="totalQuestions">
    </el-pagination>
  </div>
</template>

<script setup>
import {ref, reactive, onMounted, toRaw} from 'vue';
import instance from "@/axios.js";
import {getTableList, insertQuestion} from "@/tool/api.js";


const dialogVisible = ref(false);
const questions = ref([]);
const newQuestion = reactive({
      isCorrect: true,
      isWrong: false,
      isGuess: false,
      isUnknown: false,
      // completelyUnknown:false,
      remarks: "1",
      knowledgeType: "1",
      specialPoints: "1"
    }
);
const currentPage = ref(0);
const pageSize = ref(15);
const totalQuestions = ref(0);

const fetchQuestions = async () => {
  try {
    const response = await getTableList(currentPage,pageSize)
    console.log(response.data)
    questions.value = response.data.content;
    totalQuestions.value = response.data.totalElements;
  } catch (error) {
    console.error(error);
  }
};
const openDialog = () => {
  dialogVisible.value = true;
};

const addQuestion = async () => {
  try {
    await insertQuestion(toRaw(newQuestion))
    dialogVisible.value = false;
    fetchQuestions();
  } catch (error) {
    console.error(error);
  }
};

const editQuestion = async (row, column, cell, event) => {
  // 编辑题目的逻辑可以在这里实现
};

// TODO("delete操作将会导致整个题目的id顺序出现异常，因此不提供删除题目功能")
// const deleteQuestion = async (id) => {
//   try {
//     await instance.delete(`/questions/${id}`);
//     fetchQuestions();
//   } catch (error) {
//     console.error(error);
//   }
// };

const handlePageChange = (page) => {
  currentPage.value = page;
  fetchQuestions();
};


onMounted(() => {
  fetchQuestions();
});
</script>

<style>
.el-dialog {
  width: 80%;
}

.dialog-footer {
  text-align: right;
}

.el-table {
  width: 80%;
  height: 80%;
}
</style>
