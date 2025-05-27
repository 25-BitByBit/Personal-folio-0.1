import style from './input.module.css';

export interface InputProps {
  type?: 'text' | 'email' | 'password' | 'number';
  placeholder?: string;
  className?: string;
  disabled?: boolean;
}

export default function Input({
  type = 'text',
  placeholder = 'Enter something',
  className = '',
  disabled = false,
}: InputProps) {
  return (
    <input
      type={type}
      placeholder={placeholder}
      className={`w-full p-2 border border-gray-300 rounded ${className}`}
      disabled={disabled}
    />
  );
}
