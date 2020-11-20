<template >
    <div class="UserHome">
    <el-table
      :data="list"
      style="width: 100%">
      <el-table-column
        prop="classroomID"
        label="教室编号"
        width="180">
      </el-table-column>
      <el-table-column
        prop="region"
        label="学区"
        width="180">
      </el-table-column>
      <el-table-column
        prop="m_number"
        label="教室类型"
        width="180">
      </el-table-column>
        <el-table-column
        prop="m_type"
        label="教室类型"
        width="180">
      </el-table-column>
        <el-table-column
        prop="building"
        label="教学楼"
         width="180">
      </el-table-column>
        <el-table-column
        prop="capacity"
        label="容量"
        width="180">
      </el-table-column>
    </el-table>
    </div>
</template>





<script type="application/ecmascript">
    import api from '../api'
    import * as types from '../store/types'

    export default {
        name: 'Home',
        data () {
            return {
                msg: '',
                list: []
            }
        },
        mounted(){
            this.$store.commit(types.TITLE, 'Your Repositories');
            this.getRepository();
        },

        methods: {
            getRepository(){

                this.axios.get(api.getClassroom)
                    .then(response => {
                        console.log(response.data.data)
                        this.list = response.data.data;
                    })
            }
        }
    }
</script>