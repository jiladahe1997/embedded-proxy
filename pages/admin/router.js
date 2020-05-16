import AllAnnouncement from './announcement/AllAnnouncement'
import AddAnnouncement from './announcement/AddAnnouncement'
import VueRouter from 'vue-router'


const router = new VueRouter({ 
  mode: 'history',
  base: 'admin',
  routes: [
    { path: '/announcement/all', component: AllAnnouncement},
    { path: '/announcement/add', component: AddAnnouncement},
  ]
})

export default router