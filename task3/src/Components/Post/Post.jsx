import React, { useState } from 'react'
import { BsBookmark, BsBookmarkFill, BsEmojiSmile, BsThreeDots } from 'react-icons/bs'
import "./Post.css"
import { AiFillHeart, AiOutlineHeart } from 'react-icons/ai';
import { FaRegComment } from 'react-icons/fa';
import { RiSendPlaneLine } from 'react-icons/ri';
const Post = () => {
    const [showDropDown,setShowDropDown]=useState(false);
    const [IsPostLiked,setIsPostLiked]=useState(false);
    const [Issaved,SetIssaved]=useState(false);
    const handlesavePost=()=>{
        SetIssaved(!Issaved);
    }
    const handlePostLike=()=>{
        setIsPostLiked(!IsPostLiked);
    }
    
    
    
    const handleClick=()=>{
setShowDropDown(!showDropDown); 
    }
  return (
    <div>
        <div className='border rounded-md w-full'>
            <div className='flex justify-between items-center w-full py-4 px-5'> 
                <div className='flex items-center'>
                    <img className='h-12 w-12 rounded-full' src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS0mo1-1RPPCSd54lH3fcOeOWM1wRHxEZ3C1A&s" alt="" />
                    <div className='pl-2'>
                        <p className='font-semibold text-sm '>username</p>
                        <p className='font-thin text-sm'>location</p>
                    </div>
                </div>
                <div>
                    <BsThreeDots className='dots' onClick={handleClick} />
                    <div className='dropdown-cont'>
                       {showDropDown && <p className='bg-black text-white py-1 px-4 rounded-md cursor-pointer'>delete</p>}
                    </div>
                </div>
            </div>
            <div className='w-full'>
                <img className='w-full' src="https://res.klook.com/image/upload/c_fill,w_1265,h_712/q_80/w_80,x_15,y_15,g_south_west,l_Klook_water_br_trans_yhcmh3/activities/tsah7c9evnal289z5fig.webp" alt="" />
            </div>

            <div className='flex justify-between items-center w-full px-5 py-4'>
                <div className='flex items-center space-x-2'> 
                    {IsPostLiked?  <AiFillHeart  className='text-2xl hover:opacity-50 cursor-pointer text-red-600' onClick={handlePostLike}/> :   <AiOutlineHeart  className='text-2xl hover:opacity-50 cursor-pointer' onClick={handlePostLike} />}
                   <FaRegComment className='text-xl hover:opacity-50 cursor-pointer'/>
                  <RiSendPlaneLine  className='text-xl hover:opacity-50 cursor-pointer'/>
                </div> 
                <div className='cursor-pointer'>
                    {Issaved? <BsBookmarkFill  className='text-xl hover:opacity-50 cursor-pointer' onClick={handlesavePost}/>:  <BsBookmark  className='text-xl hover:opacity-50 cursor-pointer' onClick={handlesavePost}/> }
                    
                  
                </div>
            </div>
            <div className="flex flex-col items-start w-full py-2 px-5">
                <p>10 likes</p>
                <p className='opacity-50 py-2 cursor-pointer'>view all 10 comments</p>
            </div>

            <div className='border border-t w-full'>
                <div className='flex w-full items-center px-5'>
                    <BsEmojiSmile/>
                    <input className='commentInput' type="text " placeholder='Add a comment...' />
                </div>
            </div>
        </div>

    </div>
  );
};

export default Post