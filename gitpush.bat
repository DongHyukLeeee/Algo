:: git init

:: git remote add origin https://github.com/DongHyukLeeee/Algo

:: git add --all

:: git commit -m "before reupload"

:: git pull --rebase origin main

:: git push --set-upstream origin main

:loop

	cd C:\Users\SSAFY\Desktop\Algo\Algo

	git add --all

	git commit -m "auto commit"

	git pull

	git push
	
	TIMEOUT 300

goto loop