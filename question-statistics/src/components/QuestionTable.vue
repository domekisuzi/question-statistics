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
        <el-form-item label="Knowledge Points">
<!--          指定el-selectd 的 value-key使得option在选择时能区分，这在双向绑定的内容时对象时必须指定 -->
          <el-select
              v-model="newQuestion.knowledgePoints"
                     multiple placeholder="请选择知识点"
          :max-collapse-tags="3"
          collapse-tags
          collapse-tags-tooltip

              value-key="id"
          >

            <el-option
                v-for="knowledge in allKnowledgePoints"
                :key="knowledge.id"
                :label="knowledge.point"
                :value="knowledge"
            >
              <el-tag :style="getTagStyle(knowledge)" size="small">{{ knowledge.point }}</el-tag>
            </el-option>

          </el-select>
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
      <el-table-column prop="questionNumber" label="题号" width="50"></el-table-column>
      <el-table-column prop="isCorrect" label="对"></el-table-column>
      <el-table-column prop="isWrong" label="错"></el-table-column>
      <el-table-column prop="isGuess" label="猜"></el-table-column>
      <el-table-column prop="isUnknown" label="完全不会"></el-table-column>
      <el-table-column prop="remarks" label="备注"></el-table-column>
      <el-table-column prop="knowledgeType" label="知识点类型"></el-table-column>
      <el-table-column prop="specialPoints" label="特殊点"></el-table-column>
      <el-table-column label="知识点">
        <template #default="scope">
          <div v-if="scope.row.knowledgePoints.length">
            <el-tag
                v-for="(knowledge, index) in scope.row.knowledgePoints"
                :key="index"
                :style="getTagStyle(knowledge)"
                class="tag-margin"
            >
              {{ knowledge.point }}
            </el-tag>
          </div>
          <div v-else>无</div>
        </template>
      </el-table-column>
    </el-table>

    <el-pagination
        @current-change="handlePageChange"
        :current-page="currentPage"
        :page-size="pageSize"
        layout="prev, pager, next"
        :total="totalQuestions"
    >
    </el-pagination>
  </div>
</template>

<script setup>
import {ref, reactive, onMounted, toRaw} from 'vue';
import instance from "@/axios.js";
import {getKnowledgeList, getTableList, insertQuestion} from "@/tool/api.js";

const dialogVisible = ref(false);
const questions = ref([]);
const allKnowledgePoints = ref([]);
const newQuestion = reactive({
  isCorrect: true,
  isWrong: false,
  isGuess: false,
  isUnknown: false,
  remarks: "备注",
  knowledgeType: "暂时禁用",
  specialPoints: "特别注意点",
  knowledgePoints: [],
  questionNumber: 1
});
const currentPage = ref(0);
const pageSize = ref(15);
const totalQuestions = ref(0);

const fetchQuestions = async () => {
  try {
    const response = await getTableList(currentPage.value, pageSize.value);
    console.log(response.data);
    questions.value = response.data.content;
    totalQuestions.value = response.data.totalElements;
  } catch (error) {
    console.error(error);
  }
};

const fetchKnowledgePoints = async () => {
  try {
    const response = await getKnowledgeList();
    console.log(response.data);
    allKnowledgePoints.value = response.data;
  } catch (error) {
    console.error(error);
  }
};

const openDialog = () => {
  dialogVisible.value = true;
};

const addQuestion = async () => {
  try {
    // 更新total value 的值
    await fetchQuestions()

    const questionToAdd = toRaw(newQuestion);
    questionToAdd.questionNumber = totalQuestions.value + 1
    questionToAdd.knowledgePoints = questionToAdd.knowledgePoints.map(point => (
        {
      id: point.id,
      chapter: point.chapter,
      point: point.point,
      projectId: point.projectId
    })


    );
    console.log(questionToAdd)
    await insertQuestion(questionToAdd);
    dialogVisible.value = false;
    fetchQuestions();
  } catch (error) {
    console.error(error);
  }
};

const editQuestion = async (row, column, cell, event) => {
  // 编辑题目的逻辑可以在这里实现
};

const handlePageChange = (page) => {
  currentPage.value = page;
  fetchQuestions();
};

// Function to generate a color based on the knowledge point's chapter and projectId
const generateColor = (chapter, projectId) => {
  const hash = (chapter + projectId).split('').reduce((acc, char) => char.charCodeAt(0) + ((acc << 5) - acc), 0);
  const hue = Math.abs(hash) % 360; // Ensure hue is within 0-360
  const saturation = 60 + (Math.abs(hash) % 20); // Ensure saturation is within 60-80%
  const lightness = 70 + (Math.abs(hash) % 10); // Ensure lightness is within 70-80%
  return `hsl(${hue}, ${saturation}%, ${lightness}%)`;
};

const getTagStyle = (knowledge) => {
  return {
    'background-color': generateColor(knowledge.chapter, knowledge.projectId)
  };
};

onMounted(() => {
  fetchQuestions();
  fetchKnowledgePoints();
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

.tag-margin {
  margin: 0 2px;
}
</style>
