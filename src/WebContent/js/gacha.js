document.querySelector(`.rotateY`).animate(
	[
		{ transform: 'rotateY(0deg)' },
		{ transform: 'rotateY(360deg)' }
	],
	{
		duration: 1000,
		easing: 'linear',
		iterations: Infinity
	});