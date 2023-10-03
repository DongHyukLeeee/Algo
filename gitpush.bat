:: git init

:: git remote add origin https://github.com/DongHyukLeeee/Algo

:: git add --all

:: git commit -m "before reupload"

:: git pull --rebase origin main

:: git push --set-upstream origin main

:loop

	cd C:\Users\qwer9\OneDrive\바탕 화면\git\Algo

	git add --all

	git commit -m "auto commit"

	git pull

	git push
	
	TIMEOUT 300

goto loop