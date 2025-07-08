import Link from "next/link";

export default function PortfolioPage() {
  return (
    <div className="max-w-3xl mx-auto min-h-screen p-6 sm:p-10 space-y-10">
      {/* 헤더 */}
      <h1 className="text-2xl font-bold">포트폴리오 정보 입력</h1>

      {/* 사용자 정보 */}
      <div className="bg-white border border-gray-200 rounded-lg p-6 shadow-sm grid grid-cols-1 sm:grid-cols-[1fr_auto] gap-6">
        <div className="space-y-4">
          {/* 이름과 상태 */}
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
          {/* 기본 정보 */}
          <p className="text-sm text-gray-600">여, 2000 (24세)</p>
          {/* 이메일 */}
          <div className="flex items-center gap-2 text-sm">
            <span>📧</span>
            <p>karina@naver.com</p>
          </div>
          {/* 전화번호 */}
          <div className="flex items-center gap-2 text-sm">
            <span>📞</span>
            <span>010-1234-5678</span>
          </div>
          {/* 주소 */}
          <div className="flex items-center gap-2 text-sm">
            <span>🏠</span>
            <span>서울시 강남구</span>
          </div>
        </div>
        {/* 프로필 이미지 */}
        <div>
          <img
            src="/profile.jpg"
            alt="프로필 이미지"
            className="w-32 h-32 rounded object-cover"
          />
        </div>
      </div>

      <div className="flex justify-end">
        <Link href="/feature/portfolio/edit">
          <button
            className="px-4 py-2 border border-black text-black bg-white rounded transition hover:bg-blue-300 hover:text-white"
          >
            수정하기
          </button>
        </Link>
      </div>

      {/* Github */}
      <div>
        <p>GitHub 링크: https://github.com/username</p>
      </div>

      {/* 포트폴리오 제목 입력 */}
      <div>
        <h2 className="text-lg font-semibold mb-2">포트폴리오 제목</h2>
      </div>

      {/* 짧은 자기소개 */}
      <div>
        <p className="font-medium mb-2">짧은 자기소개</p>
        <p>자기소개 내용</p>
      </div>

      <section className="space-y-10">
        {/* 경력 */}
        <div>
          <h2 className="text-lg font-semibold border-b border-gray-300 pb-1 mb-4">
            경력
          </h2>
          <div className="flex gap-4 text-sm">
            <div className="w-24 flex-shrink-0">
              <p>2029.03 ~</p>
              <p className="text-xs text-gray-500 mt-1">5개월</p>
            </div>
            <div className="flex-1 space-y-1">
              <p>
                <span className="font-semibold">왈플회사</span>
                <span className="ml-2 text-gray-500">영업그룹</span>
              </p>
              <p className="text-gray-700 text-xs">어린이일, 자연지원일</p>
            </div>
          </div>
        </div>

        {/* 스킬 */}
        <div>
          <h2 className="text-lg font-semibold border-b border-gray-300 pb-1 mb-4">
            스킬
          </h2>
          <div className="flex gap-2 flex-wrap">
            <span className="border border-gray-400 rounded-full px-4 py-1 text-sm text-gray-700">
              Java
            </span>
          </div>
        </div>

        {/* 경험/활동/교육 */}
        <div>
          <h2 className="text-lg font-semibold border-b border-gray-300 pb-1 mb-4">
            경험/활동/교육
          </h2>
          <div className="flex gap-4 text-sm">
            <div className="w-24 flex-shrink-0">
              <p>2029.03 ~</p>
              <p className="text-xs text-gray-500 mt-1">5개월</p>
            </div>
            <div className="flex-1 space-y-1">
              <div className="flex items-center gap-2">
                <p className="font-semibold">왈플 나눔 봉사활동</p>
                <button
                  type="button"
                  className="border border-gray-400 text-xs px-2 py-0.5 rounded"
                >
                  봉사
                </button>
              </div>
              <p className="text-gray-700 text-xs">어린이일, 자연지원일</p>
            </div>
          </div>
        </div>
      </section>
    </div>
  );
}