/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{html,ts}",
  ],
  theme: {
    extend: {
      colors:{
        'dk-gray':'rgba(136, 130, 130, 0.5)',
        'dk-blue':'rgba(12, 140, 233, 1)',
        'dk-blue-footer':'rgba(22, 28, 45, 1)',
        'dk-home-gray':'rgba(248, 249, 250, 1)',
        'dk-project-gray':'rgba(248, 248, 248, 1)',
        'dk-g':'rgba(132, 146, 166, 1)',
      }
    },
  },
  plugins: [],
}

