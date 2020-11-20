
import Vuex from 'vuex'
import Vue from 'vue'
import * as types from './types'

Vue.use(Vuex);
export default new Vuex.Store({
    state: {
        id: null,
        password:null,
        token: null,
        
        title: ''
    },
    mutations: {
        [types.LOGIN]: (state, data) => {
            localStorage.token = data.id+data.password;
            state.token=data.id+data.password;
            //后端同学入土，目前没实现token 下次一定
            state.id = data.id;
            state.password=data.password;
        },
        [types.LOGOUT]: (state) => {
            localStorage.removeItem('token');
            state.token = null;
            state.id=null;
            state.password=null;
        },
        [types.TITLE]: (state, data) => {
            state.title = data;
        },
        [types.TOKEN]: (state, data) => {
            state.Token = data;
        }
    }
})