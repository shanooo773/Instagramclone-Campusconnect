import React from 'react'
import { Route, Routes } from 'react-router-dom'
import HomePage from '../HomePage/HomePage'
import Profile from '../Pages/Profile'
import Sidebar from '../../Components/Sidebar/Sidebar'
const Router = () => {
  return (
    <div>
        <div className='flex'>
            <div className='w-[20%] border border-l-slate-500 pl-10'>
                <Sidebar/>
            </div>
            <div className='w-full '>
            <Routes>
                <Route path='/' element={<HomePage/>}></Route>
                <Route path='/username' element={<Profile/>}></Route>
            </Routes>
            </div>
        </div>

    </div>
  )
}

export default Router