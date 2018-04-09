# CS61b

#### Lab1：

首先学习了如何使用git。几条常用的git命令总结：

- `git init`: Creates a box in which to permanently store panoramic pictures.
- `git add`: Takes a temporary photo of one thing that can be assembled into a panoramic photo later.
- `git commit`: Assembles all available temporary photos into a panoramic photo. Also destroys all temporary photos.
- `git log`: Lists all the panoramic photos we’ve ever taken.
- `git show`: Looks at what is in a particular panoramic photo.
- `git checkout`: Rearranges files back to how they looked in a given panoramic photo. Does not affect the panormiac photos in your box in any way.

git连接远程仓库的几条常用命令总结：

- `git clone [remote-repo-URL]`: Makes a copy of the specified repository, but on your local computer. Also creates a working directory that has files arranged exactly like the most recent snapshot in the download repository. Also records the URL of the remote repository for subsequent network data transfers, and gives it the special remote-repo-name “origin”.
- `git remote add [remote-repo-name] [remote-repo-URL]`: Records a new location for network data transfers.
- `git remote -v`: Lists all locations for network data transfers.
- `git pull [remote-repo-name] master`: Get the most recent copy of the files as seen in remote-repo-name
- `git push [remote-repo-name] master`: Pushes the most recent copy of your files to the remote-repo-name.

#### project 0：

模拟太阳系的行星运行轨迹。项目完成效果图如下：![GIF](C:\Users\dell\Desktop\CS61b\proj0\GIF.gif)



