"use client";

import "./styles/layout.css";
import Image from "next/image";
import { useState } from "react";

const images = [
  "/assets/users/login/login1.svg",
  "/assets/users/login/login2.svg",
  "/assets/users/login/login3.svg",
];

export default function UsersLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  const [currentIndex, setCurrentIndex] = useState(0);

  const handleNext = () => {
    setCurrentIndex((prev) => (prev + 1) % images.length);
  };

  const handlePrev = () => {
    setCurrentIndex((prev) => (prev - 1 + images.length) % images.length);
  };

  return (
    <section>
      {/* logo */}
      <div className="log-header"></div>

      {/* Section */}
      <div className="section-container">
        <div className="half-section">{children}</div>

        <div className="half-section">
          <div className="img-box relative w-full">
            {/* Carousel wrapper */}
            <div className=" h-56 overflow-hidden rounded-lg md:h-96">
              {images.map((src, index) => (
                <div
                  key={index}
                  className={` absolute inset-0 transition-opacity duration-700 ease-in-out ${
                    index === currentIndex ? "opacity-100" : "opacity-0"
                  }`}
                >
                  <Image
                    src={src}
                    unoptimized
                    width={100}
                    height={150}
                    priority
                    alt={`Slide ${index + 1}`}
                    className="absolute block w-full -translate-x-1/2 -translate-y-1/2 top-1/2 left-1/2"
                  />
                </div>
              ))}
            </div>

            {/* Slider indicators */}
            <div className="absolute bottom-50 z-30 flex -translate-x-1/2  left-1/2 space-x-3 rtl:space-x-reverse">
              {images.map((_, idx) => (
                <button
                  key={idx}
                  type="button"
                  onClick={() => setCurrentIndex(idx)}
                  className={`w-3 h-3 rounded-full ${
                    currentIndex === idx ? "bg-white" : "bg-gray-400"
                  }`}
                  aria-current={currentIndex === idx ? "true" : "false"}
                  aria-label={`Slide ${idx + 1}`}
                ></button>
              ))}
            </div>

            {/* Prev Button */}
            <button
              type="button"
              onClick={handlePrev}
              className="absolute top-0 start-0 z-30 flex items-center justify-center h-full px-4 cursor-pointer group focus:outline-none"
            >
              <span className="inline-flex items-center justify-center w-10 h-10 rounded-full bg-white/30 hover:bg-white/50">
                <svg
                  className="w-4 h-4 text-white"
                  xmlns="http://www.w3.org/2000/svg"
                  fill="none"
                  viewBox="0 0 6 10"
                >
                  <path
                    stroke="currentColor"
                    strokeLinecap="round"
                    strokeLinejoin="round"
                    strokeWidth="2"
                    d="M5 1 1 5l4 4"
                  />
                </svg>
                <span className="sr-only">Previous</span>
              </span>
            </button>

            {/* Next Button */}
            <button
              type="button"
              onClick={handleNext}
              className="absolute top-0 end-0 z-30 flex items-center justify-center h-full px-4 cursor-pointer group focus:outline-none"
            >
              <span className="inline-flex items-center justify-center w-10 h-10 rounded-full bg-white/30 hover:bg-white/50">
                <svg
                  className="w-4 h-4 text-white"
                  xmlns="http://www.w3.org/2000/svg"
                  fill="none"
                  viewBox="0 0 6 10"
                >
                  <path
                    stroke="currentColor"
                    strokeLinecap="round"
                    strokeLinejoin="round"
                    strokeWidth="2"
                    d="m1 9 4-4-4-4"
                  />
                </svg>
                <span className="sr-only">Next</span>
              </span>
            </button>
          </div>
        </div>
      </div>

      <nav></nav>
    </section>
  );
}
