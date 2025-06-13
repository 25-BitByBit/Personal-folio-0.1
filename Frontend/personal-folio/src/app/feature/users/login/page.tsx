"use client";
import { useRouter } from "next/navigation";
import Input from "@/components/input/Input";
// css
import "../styles/login.css";

const LoginPage = () => {
  const router = useRouter();

  const goFindPw = () => {
    router.push("/users/findPw");
  };

  return (
    <div className="h-200 w-150 flex flex-col items-center justify-center font-geist gap-3">
      {/* Title */}
      <div className="title-box">
        <div>Login</div>
      </div>
      {/* Input */}
      <div className="input-box">
        <Input label="Email" placeholder="Id" />
      </div>
      <div className="input-box">
        <Input label="Password" placeholder="Password" />
      </div>
      {/* Forgot Password */}
      <div className="text-box ">
        <p onClick={goFindPw} className="clickable-text">
          비밀번호 찾기
        </p>
      </div>
      {/* Login Btn */}
      <div className="btn-box">Login</div>
      <div className="text-box gap-3" style={{ justifyContent: "center" }}>
        <div>계정이 없으신가요?</div>
        <div className="clickable-text">회원가입 </div>
      </div>
      {/* br */}
      {/* social login */}
    </div>
  );
};

export default LoginPage;
