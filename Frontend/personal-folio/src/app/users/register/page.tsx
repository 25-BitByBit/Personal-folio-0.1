"use client";
import { useRouter } from "next/navigation";
import Input from "@/components/input/Input";
// css
import "../styles/login.css";

const RegisterPage = () => {
  const router = useRouter();

  const goLogin = () => {
    router.push("/users/login");
  };

  return (
    <div className="h-200 w-150 flex flex-col items-center justify-center font-geist gap-3">
      {/* Title */}
      <div className="title-box">
        <div>회원가입</div>
      </div>
      {/* Input */}
      <div className="input-flex-box">
        <Input label="이름" placeholder="Name" />
        <Input label="Id" placeholder="Id" />
      </div>
      <div className="input-flex-box">
        <Input label="Email" placeholder="Email" />
        <Input label="핸드폰 번호" placeholder="Phone Number" />
      </div>
      {/* 비밀번호 */}
      <div className="input-box">
        <Input label="비밀번호" placeholder="Password" />
      </div>
      {/* 비밀번호 - 확인 */}
      <div className="input-box">
        <Input label="비밀번호 확인" placeholder="Confirm Password" />
      </div>
      {/* Register Btn */}
      <div className="btn-box">회원가입</div>
      {/* Already user */}
      <div className="text-box">
        이미 회원이신가요?
        <p className="clickable-text" onClick={goLogin}>
          Login
        </p>
      </div>
      {/* br */}
      {/* social login */}
    </div>
  );
};

export default RegisterPage;
