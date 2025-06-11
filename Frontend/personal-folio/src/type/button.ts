export interface ButtonProps {
    type?: 'button' | 'submit' | 'reset';
    onClick?: () => void;
    className?: string;
    disabled?: boolean;
    children?: React.ReactNode;
    label?: string;
    variant?: 'primary' | 'secondary' | 'tertiary';
    size?: 'small' | 'medium' | 'large';

    title?: string;
    id?: string;
}
