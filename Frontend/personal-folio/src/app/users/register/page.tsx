import Input from "@/components/input/Input";

const registerPage = () => {
  return (
    <div className="h-200 w-150 flex flex-col items-center justify-center font-geist gap-3">
      {/* Title */}
      <div className="title-box">
        <div>회원가입</div>
      </div>
      {/* Input */}
      <div className="input-box">
        <Input label="Email" placeholder="Id" />
      </div>
      <div className="input-box">
        <Input label="Password" placeholder="Password" />
      </div>

      {/* Login Btn */}
      <div className="btn-box">회원가입</div>

      {/* br */}
      {/* social login */}
    </div>
  );
};

export default registerPage;
