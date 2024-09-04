module.exports = {
	testEnvironment: 'jest-environment-jsdom',
	transform: {
		'^.+\\\\.jsx?$': 'babel-jest',
	},
	moduleFileExtensions: ['js', 'jsx'],                 
	coverageDirectory: 'coverage',                       
	coverageReporters: ["text", "lcov"],
	collectCoverageFrom: ['src/**/*.{js,jsx}'],          
	moduleNameMapper: {                                  
		'\\\\.(css|less)$': '<rootDir>/styleMock.js',  
	},
};
