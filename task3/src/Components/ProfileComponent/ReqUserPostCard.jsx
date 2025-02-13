import React from 'react'
import { FaComment, FaHeart } from 'react-icons/fa'

function ReqUserPostCard() {
  return (
    <div className='p-1'>
        <div className='post w-60 h-60'>
            <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Image_created_with_a_mobile_phone.png/330px-Image_created_with_a_mobile_phone.png" alt="" />
            <div className='overlay'>
                <div className='overlay-text flex justify-between'>
                    <div><FaHeart></FaHeart> <span>10</span></div>
                    <div><FaComment/><span>30</span></div>
                </div>
            </div>
        </div>
        
    </div>
  )
}

export default ReqUserPostCard