import Input from "@/components/input/Input";
// css
import "../styles/login.css";

const LoginPage = () => {
  return (
    <div className="h-200 w-150 flex flex-col items-center justify-center font-geist gap-3">
      {/* goBack */}
      <div className="clickable-black-text">Login</div>
      {/* Title */}
      <div className="title-box">
        <h1>비밀번호 찾기</h1>
      </div>
      {/* Input */}
      <div className="input-box">
        <Input label="Email" placeholder="Id" />
      </div>

      {/* Forgot Password */}
      <div className="text-box ">
        <p className="clickable-text">Id 찾기</p>
      </div>
      {/* Login Btn */}
      <div className="btn-box">Submit</div>
      {/* br */}
      {/* social login */}
    </div>
  );
};

export default LoginPage;
