USE [master]
GO
/****** Object:  Database [Unistart2]    Script Date: 7/3/2018 8:49:57 AM ******/
CREATE DATABASE [Unistart2]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Unistart2', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\Unistart2.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Unistart2_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\Unistart2_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [Unistart2] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Unistart2].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Unistart2] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Unistart2] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Unistart2] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Unistart2] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Unistart2] SET ARITHABORT OFF 
GO
ALTER DATABASE [Unistart2] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Unistart2] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Unistart2] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Unistart2] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Unistart2] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Unistart2] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Unistart2] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Unistart2] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Unistart2] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Unistart2] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Unistart2] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Unistart2] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Unistart2] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Unistart2] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Unistart2] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Unistart2] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Unistart2] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Unistart2] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Unistart2] SET  MULTI_USER 
GO
ALTER DATABASE [Unistart2] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Unistart2] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Unistart2] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Unistart2] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [Unistart2] SET DELAYED_DURABILITY = DISABLED 
GO
USE [Unistart2]
GO
/****** Object:  Table [dbo].[Article]    Script Date: 7/3/2018 8:49:57 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Article](
	[ArticleId] [int] IDENTITY(1,1) NOT NULL,
	[SchoolId] [int] NULL,
	[Link] [nvarchar](500) NULL,
	[Status] [bit] NOT NULL,
 CONSTRAINT [PK_article] PRIMARY KEY CLUSTERED 
(
	[ArticleId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Branch]    Script Date: 7/3/2018 8:49:57 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Branch](
	[SchoolId] [int] NOT NULL,
	[BranchNo] [int] NOT NULL,
	[BranchName] [nvarchar](100) NOT NULL,
	[LocationId] [int] NULL,
	[Address] [nvarchar](200) NULL,
	[Phone] [varchar](20) NULL,
	[Website] [nvarchar](500) NULL,
 CONSTRAINT [PK_branch] PRIMARY KEY CLUSTERED 
(
	[SchoolId] ASC,
	[BranchNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[EntranceInfo]    Script Date: 7/3/2018 8:49:57 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[EntranceInfo](
	[SchoolId] [int] NOT NULL,
	[FieldId] [int] NOT NULL,
	[LevelId] [int] NOT NULL,
	[Year] [int] NOT NULL,
	[NormalEntranceAmount] [int] NULL,
	[OtherEntranceAmount] [int] NULL,
	[SjCombiCode1] [nvarchar](5) NULL,
	[Main_sjCode1] [nvarchar](5) NULL,
	[SjCombiCode2] [nvarchar](5) NULL,
	[Main_sjCode2] [nvarchar](5) NULL,
	[SjCombiCode3] [nvarchar](5) NULL,
	[Main_sjCode3] [nvarchar](5) NULL,
	[SjCombiCode4] [nvarchar](5) NULL,
	[Main_sjCode4] [nvarchar](5) NULL,
 CONSTRAINT [PK_entranceInfo] PRIMARY KEY CLUSTERED 
(
	[SchoolId] ASC,
	[FieldId] ASC,
	[LevelId] ASC,
	[Year] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Field]    Script Date: 7/3/2018 8:49:57 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Field](
	[FieldId] [int] NOT NULL,
	[FieldCode] [nvarchar](20) NOT NULL,
	[FieldName] [nvarchar](100) NOT NULL,
	[FieldTypeId] [int] IDENTITY(1,1) NOT NULL,
	[PreFieldId] [int] NULL,
 CONSTRAINT [PK_field] PRIMARY KEY CLUSTERED 
(
	[FieldId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[FieldType]    Script Date: 7/3/2018 8:49:57 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[FieldType](
	[FieldTypeId] [int] IDENTITY(1,1) NOT NULL,
	[TypeName] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_fieldType] PRIMARY KEY CLUSTERED 
(
	[FieldTypeId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Level]    Script Date: 7/3/2018 8:49:57 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Level](
	[LevelId] [int] IDENTITY(1,1) NOT NULL,
	[LevelName] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_level] PRIMARY KEY CLUSTERED 
(
	[LevelId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Location]    Script Date: 7/3/2018 8:49:57 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Location](
	[LocationId] [int] IDENTITY(1,1) NOT NULL,
	[LocationName] [nvarchar](50) NULL,
	[RegionId] [int] NULL,
 CONSTRAINT [PK_location] PRIMARY KEY CLUSTERED 
(
	[LocationId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Rate]    Script Date: 7/3/2018 8:49:57 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Rate](
	[RateId] [int] IDENTITY(1,1) NOT NULL,
	[SchoolId] [int] NULL,
	[UserId] [int] NULL,
	[Title] [nvarchar](255) NOT NULL,
	[Pros] [text] NULL,
	[Cons] [text] NULL,
	[Experience] [text] NULL,
	[Encourage] [bit] NULL,
	[UserLike] [int] NULL,
	[UserDislike] [int] NULL,
	[Anonymous] [bit] NULL,
 CONSTRAINT [PK_rate] PRIMARY KEY CLUSTERED 
(
	[RateId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[RateCriteria]    Script Date: 7/3/2018 8:49:57 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RateCriteria](
	[CriteriaId] [int] IDENTITY(1,1) NOT NULL,
	[CriteriaName] [nvarchar](255) NULL,
	[Status] [bit] NULL,
 CONSTRAINT [PK_Table_1] PRIMARY KEY CLUSTERED 
(
	[CriteriaId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[RateDetail]    Script Date: 7/3/2018 8:49:57 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RateDetail](
	[RateId] [int] NOT NULL,
	[CriteriaId] [int] NOT NULL,
	[Value] [float] NULL,
 CONSTRAINT [PK_rateDetail] PRIMARY KEY CLUSTERED 
(
	[RateId] ASC,
	[CriteriaId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Region]    Script Date: 7/3/2018 8:49:57 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Region](
	[RegionId] [int] NOT NULL,
	[RegionName] [nvarchar](50) NULL,
 CONSTRAINT [PK_region] PRIMARY KEY CLUSTERED 
(
	[RegionId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Report]    Script Date: 7/3/2018 8:49:57 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Report](
	[RateId] [int] NOT NULL,
	[UserId] [int] NOT NULL,
	[RpContent] [text] NOT NULL,
 CONSTRAINT [PK_report] PRIMARY KEY CLUSTERED 
(
	[RateId] ASC,
	[UserId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[School]    Script Date: 7/3/2018 8:49:57 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[School](
	[SchoolId] [int] IDENTITY(1,1) NOT NULL,
	[SchoolName] [nvarchar](100) NOT NULL,
	[SchoolCode] [nvarchar](50) NULL,
	[TypeId] [int] NULL,
	[Website] [nvarchar](500) NULL,
	[Phone] [varchar](50) NULL,
	[Email] [nvarchar](100) NULL,
	[Avatar] [nvarchar](500) NULL,
 CONSTRAINT [PK_school] PRIMARY KEY CLUSTERED 
(
	[SchoolId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Subject]    Script Date: 7/3/2018 8:49:57 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Subject](
	[SubjectCode] [nvarchar](5) NOT NULL,
	[SubjectName] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_subject] PRIMARY KEY CLUSTERED 
(
	[SubjectCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[SubjectCombination]    Script Date: 7/3/2018 8:49:57 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SubjectCombination](
	[SjCombiCode] [nvarchar](5) NOT NULL,
	[SjCode1] [nvarchar](5) NULL,
	[SjCode2] [nvarchar](5) NULL,
	[SjCode3] [nvarchar](5) NULL,
 CONSTRAINT [PK_subjectCombination] PRIMARY KEY CLUSTERED 
(
	[SjCombiCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Type]    Script Date: 7/3/2018 8:49:57 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Type](
	[TypeId] [int] IDENTITY(1,1) NOT NULL,
	[TypeName] [nvarchar](100) NOT NULL,
 CONSTRAINT [PK_type] PRIMARY KEY CLUSTERED 
(
	[TypeId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[User]    Script Date: 7/3/2018 8:49:57 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[UserId] [int] IDENTITY(1,1) NOT NULL,
	[Email] [nvarchar](200) NULL,
	[Name] [nvarchar](200) NULL,
	[Avatar] [nvarchar](500) NULL,
 CONSTRAINT [PK_user] PRIMARY KEY CLUSTERED 
(
	[UserId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
ALTER TABLE [dbo].[Article] ADD  CONSTRAINT [DF_article_status]  DEFAULT ((1)) FOR [Status]
GO
ALTER TABLE [dbo].[Article]  WITH CHECK ADD  CONSTRAINT [FK_article_school] FOREIGN KEY([SchoolId])
REFERENCES [dbo].[School] ([SchoolId])
GO
ALTER TABLE [dbo].[Article] CHECK CONSTRAINT [FK_article_school]
GO
ALTER TABLE [dbo].[Branch]  WITH CHECK ADD  CONSTRAINT [FK_branch_location] FOREIGN KEY([LocationId])
REFERENCES [dbo].[Location] ([LocationId])
GO
ALTER TABLE [dbo].[Branch] CHECK CONSTRAINT [FK_branch_location]
GO
ALTER TABLE [dbo].[Branch]  WITH CHECK ADD  CONSTRAINT [FK_branch_school] FOREIGN KEY([SchoolId])
REFERENCES [dbo].[School] ([SchoolId])
GO
ALTER TABLE [dbo].[Branch] CHECK CONSTRAINT [FK_branch_school]
GO
ALTER TABLE [dbo].[EntranceInfo]  WITH CHECK ADD  CONSTRAINT [FK_entranceInfo_field] FOREIGN KEY([FieldId])
REFERENCES [dbo].[Field] ([FieldId])
GO
ALTER TABLE [dbo].[EntranceInfo] CHECK CONSTRAINT [FK_entranceInfo_field]
GO
ALTER TABLE [dbo].[EntranceInfo]  WITH CHECK ADD  CONSTRAINT [FK_entranceInfo_level] FOREIGN KEY([LevelId])
REFERENCES [dbo].[Level] ([LevelId])
GO
ALTER TABLE [dbo].[EntranceInfo] CHECK CONSTRAINT [FK_entranceInfo_level]
GO
ALTER TABLE [dbo].[EntranceInfo]  WITH CHECK ADD  CONSTRAINT [FK_entranceInfo_school] FOREIGN KEY([SchoolId])
REFERENCES [dbo].[School] ([SchoolId])
GO
ALTER TABLE [dbo].[EntranceInfo] CHECK CONSTRAINT [FK_entranceInfo_school]
GO
ALTER TABLE [dbo].[EntranceInfo]  WITH CHECK ADD  CONSTRAINT [FK_entranceInfo_subject] FOREIGN KEY([Main_sjCode1])
REFERENCES [dbo].[Subject] ([SubjectCode])
GO
ALTER TABLE [dbo].[EntranceInfo] CHECK CONSTRAINT [FK_entranceInfo_subject]
GO
ALTER TABLE [dbo].[EntranceInfo]  WITH CHECK ADD  CONSTRAINT [FK_entranceInfo_subject1] FOREIGN KEY([Main_sjCode2])
REFERENCES [dbo].[Subject] ([SubjectCode])
GO
ALTER TABLE [dbo].[EntranceInfo] CHECK CONSTRAINT [FK_entranceInfo_subject1]
GO
ALTER TABLE [dbo].[EntranceInfo]  WITH CHECK ADD  CONSTRAINT [FK_entranceInfo_subject2] FOREIGN KEY([Main_sjCode3])
REFERENCES [dbo].[Subject] ([SubjectCode])
GO
ALTER TABLE [dbo].[EntranceInfo] CHECK CONSTRAINT [FK_entranceInfo_subject2]
GO
ALTER TABLE [dbo].[EntranceInfo]  WITH CHECK ADD  CONSTRAINT [FK_entranceInfo_subject3] FOREIGN KEY([Main_sjCode4])
REFERENCES [dbo].[Subject] ([SubjectCode])
GO
ALTER TABLE [dbo].[EntranceInfo] CHECK CONSTRAINT [FK_entranceInfo_subject3]
GO
ALTER TABLE [dbo].[EntranceInfo]  WITH CHECK ADD  CONSTRAINT [FK_entranceInfo_subjectCombination] FOREIGN KEY([SjCombiCode1])
REFERENCES [dbo].[SubjectCombination] ([SjCombiCode])
GO
ALTER TABLE [dbo].[EntranceInfo] CHECK CONSTRAINT [FK_entranceInfo_subjectCombination]
GO
ALTER TABLE [dbo].[EntranceInfo]  WITH CHECK ADD  CONSTRAINT [FK_entranceInfo_subjectCombination1] FOREIGN KEY([SjCombiCode2])
REFERENCES [dbo].[SubjectCombination] ([SjCombiCode])
GO
ALTER TABLE [dbo].[EntranceInfo] CHECK CONSTRAINT [FK_entranceInfo_subjectCombination1]
GO
ALTER TABLE [dbo].[EntranceInfo]  WITH CHECK ADD  CONSTRAINT [FK_entranceInfo_subjectCombination2] FOREIGN KEY([SjCombiCode3])
REFERENCES [dbo].[SubjectCombination] ([SjCombiCode])
GO
ALTER TABLE [dbo].[EntranceInfo] CHECK CONSTRAINT [FK_entranceInfo_subjectCombination2]
GO
ALTER TABLE [dbo].[EntranceInfo]  WITH CHECK ADD  CONSTRAINT [FK_entranceInfo_subjectCombination3] FOREIGN KEY([SjCombiCode4])
REFERENCES [dbo].[SubjectCombination] ([SjCombiCode])
GO
ALTER TABLE [dbo].[EntranceInfo] CHECK CONSTRAINT [FK_entranceInfo_subjectCombination3]
GO
ALTER TABLE [dbo].[Field]  WITH CHECK ADD  CONSTRAINT [FK_field_field] FOREIGN KEY([PreFieldId])
REFERENCES [dbo].[Field] ([FieldId])
GO
ALTER TABLE [dbo].[Field] CHECK CONSTRAINT [FK_field_field]
GO
ALTER TABLE [dbo].[Field]  WITH CHECK ADD  CONSTRAINT [FK_field_fieldType] FOREIGN KEY([FieldTypeId])
REFERENCES [dbo].[FieldType] ([FieldTypeId])
GO
ALTER TABLE [dbo].[Field] CHECK CONSTRAINT [FK_field_fieldType]
GO
ALTER TABLE [dbo].[Location]  WITH CHECK ADD  CONSTRAINT [FK_location_region] FOREIGN KEY([RegionId])
REFERENCES [dbo].[Region] ([RegionId])
GO
ALTER TABLE [dbo].[Location] CHECK CONSTRAINT [FK_location_region]
GO
ALTER TABLE [dbo].[Rate]  WITH CHECK ADD  CONSTRAINT [FK_rate_school] FOREIGN KEY([SchoolId])
REFERENCES [dbo].[School] ([SchoolId])
GO
ALTER TABLE [dbo].[Rate] CHECK CONSTRAINT [FK_rate_school]
GO
ALTER TABLE [dbo].[Rate]  WITH CHECK ADD  CONSTRAINT [FK_rate_user] FOREIGN KEY([UserId])
REFERENCES [dbo].[User] ([UserId])
GO
ALTER TABLE [dbo].[Rate] CHECK CONSTRAINT [FK_rate_user]
GO
ALTER TABLE [dbo].[RateDetail]  WITH CHECK ADD  CONSTRAINT [FK_rateDetail_rate] FOREIGN KEY([RateId])
REFERENCES [dbo].[Rate] ([RateId])
GO
ALTER TABLE [dbo].[RateDetail] CHECK CONSTRAINT [FK_rateDetail_rate]
GO
ALTER TABLE [dbo].[RateDetail]  WITH CHECK ADD  CONSTRAINT [FK_rateDetail_rateCriteria] FOREIGN KEY([CriteriaId])
REFERENCES [dbo].[RateCriteria] ([CriteriaId])
GO
ALTER TABLE [dbo].[RateDetail] CHECK CONSTRAINT [FK_rateDetail_rateCriteria]
GO
ALTER TABLE [dbo].[Report]  WITH CHECK ADD  CONSTRAINT [FK_report_rate] FOREIGN KEY([RateId])
REFERENCES [dbo].[Rate] ([RateId])
GO
ALTER TABLE [dbo].[Report] CHECK CONSTRAINT [FK_report_rate]
GO
ALTER TABLE [dbo].[Report]  WITH CHECK ADD  CONSTRAINT [FK_report_user] FOREIGN KEY([UserId])
REFERENCES [dbo].[User] ([UserId])
GO
ALTER TABLE [dbo].[Report] CHECK CONSTRAINT [FK_report_user]
GO
ALTER TABLE [dbo].[School]  WITH CHECK ADD  CONSTRAINT [FK_school_type1] FOREIGN KEY([TypeId])
REFERENCES [dbo].[Type] ([TypeId])
GO
ALTER TABLE [dbo].[School] CHECK CONSTRAINT [FK_school_type1]
GO
ALTER TABLE [dbo].[SubjectCombination]  WITH CHECK ADD  CONSTRAINT [FK_subjectCombination_subject] FOREIGN KEY([SjCode1])
REFERENCES [dbo].[Subject] ([SubjectCode])
GO
ALTER TABLE [dbo].[SubjectCombination] CHECK CONSTRAINT [FK_subjectCombination_subject]
GO
ALTER TABLE [dbo].[SubjectCombination]  WITH CHECK ADD  CONSTRAINT [FK_subjectCombination_subject1] FOREIGN KEY([SjCode2])
REFERENCES [dbo].[Subject] ([SubjectCode])
GO
ALTER TABLE [dbo].[SubjectCombination] CHECK CONSTRAINT [FK_subjectCombination_subject1]
GO
ALTER TABLE [dbo].[SubjectCombination]  WITH CHECK ADD  CONSTRAINT [FK_subjectCombination_subject2] FOREIGN KEY([SjCode3])
REFERENCES [dbo].[Subject] ([SubjectCode])
GO
ALTER TABLE [dbo].[SubjectCombination] CHECK CONSTRAINT [FK_subjectCombination_subject2]
GO
USE [master]
GO
ALTER DATABASE [Unistart2] SET  READ_WRITE 
GO
