export default function Card() {
  return (
    <div className="bg-white shadow-md">
      <div className="flex items-center p-4">
        <img
          src="/"
          alt="User Profile"
          className="w-8 h-8 rounded-full inline-block mr-2"
        />
        <p>사용자 이름</p>
      </div>
      
      <div className="w-160 h-160 aspect-square">
        <img
          src="/"
          alt="User Portfolio"
          className="w-full h-full object-cover"
        />
      </div>
      <div className="p-4">
        <p> 댓글 / 좋아요 알림창</p>
      </div>
      <div className="p-4">
        <p> 텍스트 부분</p>
      </div>
    </div>
  );
}