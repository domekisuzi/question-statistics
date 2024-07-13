//made by @domekisuzi at 2024/7/12:8:49
import instance from "@/axios.js";

// api页面，注意返回的都是response
// 获取列表 page页的数据
export const   getTableList = async (currentPage,pageSize) =>{
     return instance.get('/questions/page', {
        params: {
            page: currentPage.value,
            size: pageSize.value
        }
    });
}

export  const insertQuestion = async  (newQuestion) =>{
    return instance.post('/questions',newQuestion,
        {
            headers: {
                'Content-Type': ' application/json'
            }
        }
    );
}

// 获取知识点列表


export  const getKnowledgeList = async () => {
    return instance.get('/knowledgePoints')
}

