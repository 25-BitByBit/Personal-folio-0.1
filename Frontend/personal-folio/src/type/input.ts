// src/types/input.ts
import { InputHTMLAttributes } from 'react';

export interface InputProps extends InputHTMLAttributes<HTMLInputElement> {
    type?: 'text' | 'email' | 'password' | 'number';
    placeholder?: string;
    className?: string;
    disabled?: boolean;
    label?: string;
}
