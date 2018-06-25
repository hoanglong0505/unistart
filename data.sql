USE [master]
GO
/****** Object:  Database [Unistart]    Script Date: 25-06-2018 10:39:15 AM ******/
CREATE DATABASE [Unistart]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Unistart', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\Unistart.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Unistart_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\Unistart_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [Unistart] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Unistart].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Unistart] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Unistart] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Unistart] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Unistart] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Unistart] SET ARITHABORT OFF 
GO
ALTER DATABASE [Unistart] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Unistart] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Unistart] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Unistart] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Unistart] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Unistart] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Unistart] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Unistart] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Unistart] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Unistart] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Unistart] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Unistart] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Unistart] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Unistart] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Unistart] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Unistart] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Unistart] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Unistart] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Unistart] SET  MULTI_USER 
GO
ALTER DATABASE [Unistart] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Unistart] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Unistart] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Unistart] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [Unistart] SET DELAYED_DURABILITY = DISABLED 
GO
USE [Unistart]
GO
/****** Object:  Table [dbo].[Branch]    Script Date: 25-06-2018 10:39:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Branch](
	[BranchId] [int] NOT NULL,
	[BranchName] [nvarchar](500) NOT NULL,
	[UniversityId] [int] NOT NULL,
	[LocationId] [int] NOT NULL,
	[Address] [nvarchar](4000) NOT NULL,
	[Phone] [nchar](200) NULL,
 CONSTRAINT [PK_Branch] PRIMARY KEY CLUSTERED 
(
	[BranchId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Level]    Script Date: 25-06-2018 10:39:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Level](
	[LevelId] [int] NOT NULL,
	[LevelName] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Level] PRIMARY KEY CLUSTERED 
(
	[LevelId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Location]    Script Date: 25-06-2018 10:39:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Location](
	[LocationId] [int] NOT NULL,
	[LocationName] [nvarchar](50) NOT NULL,
	[SubLocationId] [int] NOT NULL,
 CONSTRAINT [PK_Location] PRIMARY KEY CLUSTERED 
(
	[LocationId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[SubLocation]    Script Date: 25-06-2018 10:39:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SubLocation](
	[SubLocationId] [int] NOT NULL,
	[SubLocationName] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_SubLocation] PRIMARY KEY CLUSTERED 
(
	[SubLocationId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Type]    Script Date: 25-06-2018 10:39:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Type](
	[TypeId] [int] NOT NULL,
	[TypeName] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Type] PRIMARY KEY CLUSTERED 
(
	[TypeId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[University]    Script Date: 25-06-2018 10:39:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[University](
	[UniversityId] [int] NOT NULL,
	[UniversityName] [nvarchar](500) NOT NULL,
	[UniversityCode] [nvarchar](50) NOT NULL,
	[Website] [nchar](10) NOT NULL,
	[TypeId] [int] NOT NULL,
	[LevelId] [int] NOT NULL,
 CONSTRAINT [PK_University] PRIMARY KEY CLUSTERED 
(
	[UniversityId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
ALTER TABLE [dbo].[Branch]  WITH CHECK ADD  CONSTRAINT [FK_Branch_Location] FOREIGN KEY([LocationId])
REFERENCES [dbo].[Location] ([LocationId])
GO
ALTER TABLE [dbo].[Branch] CHECK CONSTRAINT [FK_Branch_Location]
GO
ALTER TABLE [dbo].[Branch]  WITH CHECK ADD  CONSTRAINT [FK_Branch_University] FOREIGN KEY([UniversityId])
REFERENCES [dbo].[University] ([UniversityId])
GO
ALTER TABLE [dbo].[Branch] CHECK CONSTRAINT [FK_Branch_University]
GO
ALTER TABLE [dbo].[Location]  WITH CHECK ADD  CONSTRAINT [FK_Location_SubLocation] FOREIGN KEY([SubLocationId])
REFERENCES [dbo].[SubLocation] ([SubLocationId])
GO
ALTER TABLE [dbo].[Location] CHECK CONSTRAINT [FK_Location_SubLocation]
GO
ALTER TABLE [dbo].[University]  WITH CHECK ADD  CONSTRAINT [FK_University_Level] FOREIGN KEY([LevelId])
REFERENCES [dbo].[Level] ([LevelId])
GO
ALTER TABLE [dbo].[University] CHECK CONSTRAINT [FK_University_Level]
GO
ALTER TABLE [dbo].[University]  WITH CHECK ADD  CONSTRAINT [FK_University_Type] FOREIGN KEY([TypeId])
REFERENCES [dbo].[Type] ([TypeId])
GO
ALTER TABLE [dbo].[University] CHECK CONSTRAINT [FK_University_Type]
GO
USE [master]
GO
ALTER DATABASE [Unistart] SET  READ_WRITE 
GO
