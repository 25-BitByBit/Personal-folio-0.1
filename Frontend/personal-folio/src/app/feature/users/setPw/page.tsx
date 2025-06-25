import Input from "@/components/input/Input";
// css
import "../styles/login.css";

const SetPasswordPage = () => {
  return (
    <div className="h-200 w-150 flex flex-col items-center justify-center font-geist gap-3">
      {/* goBack */}
      {/* Title */}
      <div className="title-box">
        <h1>비밀번호 변경</h1>
      </div>
      {/* Input */}
      <div className="input-box">
        <Input label="새 비밀번호" type="password" placeholder="새 비밀번호" />
      </div>
      <div className="input-box">
        <Input
          label="비밀번호 확인"
          type="password"
          placeholder="새 비밀번호"
        />
      </div>
      {/* Login Btn */}
      <div className="btn-box">비밀번호 변경</div>
      {/* br */}
      {/* social login */}
    </div>
  );
};

export default SetPasswordPage;
