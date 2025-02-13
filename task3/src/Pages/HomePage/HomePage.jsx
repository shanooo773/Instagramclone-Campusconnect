import React from "react";
import Storycircle from "../../Components/story/Storycircle";
import Homerigh from "../../Components/Homeright/Homerigh";
import Post from "../../Components/Post/Post";
function HomePage() {
  return (
    <div>
      <div className="mt-10 flex w-[100%] justify-center">
        <div className="w-[44%] px-10">
          <div className="storyDiv flex space-x-2 border p-4 rounded-md justify-start w-full">
            {[1, 1, 11].map((item) => (
              <Storycircle />
            ))}
          </div>
          <div className="space-y-10 w-full mt-10">
            {[1,1].map((item)=><Post/>)}
          </div>
        </div>
        <div className="w-[35%]">
           <Homerigh/> 
        </div>
      </div>
    </div>
  );
}

export default HomePage;
