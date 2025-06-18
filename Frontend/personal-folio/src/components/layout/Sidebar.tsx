'use client';

import Link from 'next/link';

export default function Sidebar() {
  return (
    <aside className="w-16 bg-gray-100 text-gray-800 h-screen sticky top-0 flex items-center justify-center">
      <nav className="flex flex-col items-center gap-4">
        <Link href="/feature/company">회사</Link>
        <Link href="/feature/portfolio">portfolio</Link>
        <Link href="/feature/userSeeker">user찾기</Link>
      </nav>
    </aside>
  )
}