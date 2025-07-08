"use client";

import { useState } from "react";
import Input from "@/components/input/Input";
import Button from "@/components/button/Button";

export default function PortfolioEditPage() {
  // 상태 예시
  const [github, setGithub] = useState("");
  const [portfolioTitle, setPortfolioTitle] = useState("");
  const [career, setCareer] = useState({});
  const [skill, setSkill] = useState("");
  const [experience, setExperience] = useState({});
  const [introduction, setIntroduction] = useState("");

  // 버튼 핸들러 예시
  const handleSave = (section: string) => {
    console.log(`${section} 저장`);
  };
  const handleSaveAll = () => {
    console.log("전체 저장");
  };

  return (
    <div className="max-w-3xl mx-auto min-h-screen p-6 sm:p-10 space-y-10">
      {/* 헤더 */}
      <h1 className="text-2xl font-bold">포트폴리오 정보 편집</h1>

      {/* 사용자 정보 */}
      <div className="bg-white border border-gray-200 rounded-lg p-6 shadow-sm grid grid-cols-1 sm:grid-cols-[1fr_auto] gap-6">
        <div className="space-y-4">
          <div className="flex items-center gap-4">
            <h2 className="text-xl font-semibold">카리나</h2>
            <select
              className="border border-gray-300 rounded px-2 py-1 text-sm"
              defaultValue="신입"
            >
              <option value="신입">신입</option>
              <option value="경력">경력</option>
            </select>
          </div>
          <p className="text-sm text-gray-600">여, 2000 (24세)</p>
          <div className="flex items-center gap-2 text-sm">
            <span>📧</span>
            <a
              href="mailto:karina@naver.com"
              className="text-blue-600 underline"
            >
              karina@naver.com
            </a>
          </div>
          <div className="flex items-center gap-2 text-sm">
            <span>📞</span>
            <span>010-1234-5678</span>
          </div>
          <div className="flex items-center gap-2 text-sm">
            <span>🏠</span>
            <span>서울시 강남구</span>
          </div>
        </div>
        <div>
          <img
            src="/profile.jpg"
            alt="프로필 이미지"
            className="w-32 h-32 rounded object-cover"
          />
        </div>
      </div>

      {/* GitHub */}
      <div>
        <div className="flex justify-between items-center mb-2">
          <p className="font-medium">GitHub 링크</p>
          <Button
            label="입력"
            variant={undefined}
            size="small"
            onClick={() => handleSave("GitHub 링크")}
            className="border border-black text-black bg-transparent hover:bg-blue-300 hover:text-white text-xs px-2 py-0.5"
          />
        </div>
        <Input
          id="github"
          placeholder="https://github.com/username"
          value={github}
          onChange={(e) => setGithub(e.target.value)}
        />
      </div>

      {/* 짧은 자기소개 */}
      <div>
        <div className="flex justify-between items-center mb-2">
          <p className="font-medium">짧은 자기소개</p>
          <Button
            label="입력"
            size="small"
            onClick={() => handleSave("짧은 자기소개")}
            className="border border-black text-black bg-transparent hover:bg-blue-300 hover:text-white text-xs px-2 py-0.5"
          />
        </div>
        <textarea
          value={introduction}
          onChange={(e) => setIntroduction(e.target.value)}
          placeholder="Rich text editor."
          className="w-full h-32 border border-gray-300 rounded p-3 text-sm focus:outline-none focus:ring-2 focus:ring-blue-500"
        />
      </div>

      {/* 포트폴리오 제목 */}
      <div>
        <div className="flex justify-between items-center mb-2">
          <p className="font-medium">포트폴리오 제목</p>
          <Button
            label="입력"
            size="small"
            onClick={() => handleSave("포트폴리오 제목")}
            className="border border-black text-black bg-transparent hover:bg-blue-300 hover:text-white text-xs px-2 py-0.5"
          />
        </div>
        <Input
          id="portfolioTitle"
          placeholder="Enter your portfolio title"
          value={portfolioTitle}
          onChange={(e) => setPortfolioTitle(e.target.value)}
        />
      </div>

      <section className="space-y-10">
        {/* 경력 */}
        <div>
          <div className="flex justify-between items-center mb-4">
            <h2 className="text-lg font-semibold">경력</h2>
            <Button
              label="입력"
              size="small"
              onClick={() => handleSave("경력")}
              className="border border-black text-black bg-transparent hover:bg-blue-600 hover:text-white text-xs px-2 py-0.5"
            />
          </div>
          <div className="space-y-4">
            <Input
              id="careerCompany"
              label="회사명"
              placeholder="예: 왈플회사"
            />
            <Input
              id="careerDepartment"
              label="부서명"
              placeholder="예: 영업그룹"
            />
            <Input
              id="careerPeriod"
              label="근무기간"
              placeholder="예: 2029.03 ~"
            />
            <Input
              id="careerDescription"
              label="담당 업무"
              placeholder="예: 어린이일, 자연지원일"
            />
          </div>
        </div>

        {/* 스킬 */}
        <div>
          <div className="flex justify-between items-center mb-4">
            <h2 className="text-lg font-semibold">스킬</h2>
            <Button
              label="입력"
              size="small"
              onClick={() => handleSave("스킬")}
              className="border border-black text-black bg-transparent hover:bg-blue-300 hover:text-white text-xs px-2 py-0.5"
            />
          </div>
          <div className="space-y-4">
            <Input
              id="skill"
              label="스킬명"
              placeholder="예: Java, React, Node.js"
              value={skill}
              onChange={(e) => setSkill(e.target.value)}
            />
          </div>
        </div>

        {/* 경험/활동/교육 */}
        <div>
          <div className="flex justify-between items-center mb-4">
            <h2 className="text-lg font-semibold">경험/활동/교육</h2>
            <Button
              label="입력"
              size="small"
              onClick={() => handleSave("경험")}
              className="border border-black text-black bg-transparent hover:bg-blue-300 hover:text-white text-xs px-2 py-0.5"
            />
          </div>
          <div className="space-y-4">
            <Input
              id="experienceTitle"
              label="활동명"
              placeholder="예: 왈플 나눔 봉사활동"
            />
            <Input
              id="experienceType"
              label="활동구분"
              placeholder="예: 봉사, 교육, 활동"
            />
            <Input
              id="experiencePeriod"
              label="기간"
              placeholder="예: 2029.03 ~"
            />
            <textarea
              placeholder="활동 상세 내용"
              className="w-full h-24 border border-gray-300 rounded p-3 text-sm focus:outline-none focus:ring-2 focus:ring-blue-500"
            />
          </div>
        </div>
      </section>

      {/* 전체 저장 버튼 */}
      <div className="pt-6 border-t border-gray-300 flex justify-center">
        <Button
          label="전체 저장"
          size="small"
          onClick={handleSaveAll}
          className="border border-black text-black bg-transparent hover:bg-blue-300 hover:text-white text-xs px-2 py-0.5"
        />
      </div>
    </div>
  );
}
