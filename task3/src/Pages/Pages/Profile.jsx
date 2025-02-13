import React from 'react'
import { Profileuserdata } from '../../Components/ProfileComponent/Profileuserdata'
import ReqUserPost from '../../Components/ProfileComponent/ReqUserPost'




function Profile() {
  return (
    <div className='px-20'>
      <div>
        <Profileuserdata/>
      </div>
      <div>
        <ReqUserPost/>
      </div>
    </div>
  )
}

export default Profile