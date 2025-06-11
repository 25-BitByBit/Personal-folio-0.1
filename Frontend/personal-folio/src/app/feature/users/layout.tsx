"use client";

import "./styles/layout.css";
import Carousel from "@/components/carousel/Carousel";
import { usePathname } from "next/navigation";

export default function UsersLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  const pathname = usePathname();

  const isRegisterPage = pathname === "/users/register"; // 경로 확인

  return (
    <section>
      {/* logo */}
      <div className="log-header"></div>

      {/* Section */}
      <div className="section-container">
        {isRegisterPage ? (
          <>
            <div className="half-section">
              <Carousel />
            </div>
            <div className="half-section">{children}</div>
          </>
        ) : (
          <>
            <div className="half-section">{children}</div>
            <div className="half-section">
              <Carousel />
            </div>
          </>
        )}
      </div>

      <nav></nav>
    </section>
  );
}
