//にわとり回転
document.querySelector('.gacha_btn').addEventListener('click', (e) => {
e.stopPropagation();
document.querySelector(`.rotateY`).animate(
	[
		{ transform: 'rotateY(0deg)' },
		{ transform: 'rotateY(360deg)' }
	],
	{
		duration: 300,
		easing: 'linear',
		iterations: 10
	});
	})
//たまご出現