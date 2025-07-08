// 추가할 거 clsx 라이브러리 사용 여부
'use client';

import { ButtonProps } from "@/type/button";

export default function Button({
  type = "button",
  onClick,
  className = "",
  disabled = false,
  children,
  label,
  variant = "primary",
  size = "medium",
  title,
  id,
}: ButtonProps) {
  const disabledStyles = disabled ? "opacity-50 cursor-not-allowed" : "";
  const baseStyles =
    "px-4 py-2 rounded focus:outline-none focus:ring-2 focus:ring-offset-2";
  const variantStyles = {
    primary: "bg-blue-600 text-black hover:bg-blue-300",
    secondary: "bg-gray-600 text-black hover:bg-gray-300",
    tertiary:
      "bg-transparent text-blue-600 border border-blue-600 hover:bg-blue-50",
  };
  const sizeStyles = {
    small: "px-3 py-1 text-sm",
    medium: "px-4 py-2 text-base",
    large: "px-5 py-3 text-lg",
  };
  return (
    <button
      type={type}
      onClick={onClick}
      className={`${baseStyles} ${variantStyles[variant] || ""} ${
        sizeStyles[size]
      } ${disabledStyles} ${className}`}
      disabled={disabled}
      title={title}
      id={id}
    >
      {label || children}
    </button>
  );
}