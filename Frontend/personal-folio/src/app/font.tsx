import { IBM_Plex_Sans_KR } from "next/font/google"; 
import localFont from "next/font/local";

export const ibmPlexSansKR = IBM_Plex_Sans_KR({
  subsets: ["latin"],
  weight: ["100", "200", "300", "400", "500", "600", "700"],
  variable: "--font-ibm",
});

/*
Thin 100
ExtraLight 200
Light 300
Regular 400
Medium 500
SemiBold 600
Bold 700
*/

export const nanumHuman = localFont({
    src: [
        { 
            path: '../fonts/NanumHumanEL.ttf', 
            weight: '100', 
            style: 'normal' 
        },
        { 
            path: '../fonts/NanumHumanLight.ttf',
            weight: '300', 
            style: 'normal' 
        },
        { 
            path: '../fonts/NanumHumanRegular.ttf', 
            weight: '400', 
            style: 'normal' 
        },
        { 
            path: '../fonts/NanumHumanBold.ttf', 
            weight: '700', 
            style: 'normal' 
        },
        { 
            path: '../fonts/NanumHumanEB.ttf', 
            weight: '800', 
            style: 'normal' 
        },
        { 
            path: '../fonts/NanumHumanHeavy.ttf', 
            weight: '900', 
            style: 'normal' 
        },
    ],
    variable: "--font-nanum-human",
    display: "swap",
});

