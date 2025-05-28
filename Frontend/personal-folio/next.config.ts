/** @type {import('next').NextConfig} */
const nextConfig = {
  output: "export",
  trailingSlash: true,
  images: {
    unoptimized: true, // next/image 쓸 경우 필요
  },
};

module.exports = nextConfig;
