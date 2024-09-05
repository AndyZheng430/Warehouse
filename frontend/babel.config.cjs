// module.exports = {
// 	presets: [
// 		'@babel/preset-env', 
// 		'@babel/preset-react'],      
// 	"plugins": [
// 		"@babel/plugin-transform-runtime"
// 	]             
// };

module.exports = {
	presets: [
	  '@babel/preset-env',
	  ['@babel/preset-react', {runtime: 'automatic'}],
	],
  };