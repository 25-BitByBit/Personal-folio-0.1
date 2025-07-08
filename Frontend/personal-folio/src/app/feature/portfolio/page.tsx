import Input from "@/components/input/Input";

export default function PortfolioPage() {
  return (
    <div className="grid grid-rows-[20px_1fr_20px] items-center justify-items-center min-h-screen p-8 pb-20 gap-16 sm:p-20">
      <h1> PortfolioPage </h1>
      {/* 유저 정보 페이지 */}
      <div>
        <p>user.name</p>
        <p>user.email</p>
        <p>user.phone</p>
        <p>user.address</p>
      </div>
      <div>
        <p>짧은 자기소개</p>
        <Input placeholder="Enter a short introduction" />
      </div>
      <Input placeholder="Enter your portfolio title" />
    </div>
  );
}
