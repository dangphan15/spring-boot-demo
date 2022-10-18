USE [master]
GO
/****** Object:  Database [springbootnews]    Script Date: 2022/10/18 23:59:10 ******/
CREATE DATABASE [springbootnews]

GO
ALTER DATABASE [springbootnews] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [springbootnews] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [springbootnews] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [springbootnews] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [springbootnews] SET ARITHABORT OFF 
GO
ALTER DATABASE [springbootnews] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [springbootnews] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [springbootnews] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [springbootnews] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [springbootnews] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [springbootnews] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [springbootnews] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [springbootnews] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [springbootnews] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [springbootnews] SET  DISABLE_BROKER 
GO
ALTER DATABASE [springbootnews] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [springbootnews] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [springbootnews] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [springbootnews] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [springbootnews] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [springbootnews] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [springbootnews] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [springbootnews] SET RECOVERY FULL 
GO
ALTER DATABASE [springbootnews] SET  MULTI_USER 
GO
ALTER DATABASE [springbootnews] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [springbootnews] SET DB_CHAINING OFF 
GO
ALTER DATABASE [springbootnews] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [springbootnews] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [springbootnews] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [springbootnews] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'springbootnews', N'ON'
GO
ALTER DATABASE [springbootnews] SET QUERY_STORE = OFF
GO
USE [springbootnews]
GO
/****** Object:  Table [dbo].[category]    Script Date: 2022/10/18 23:59:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[category](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[created_by] [varchar](255) NULL,
	[created_date] [datetime] NULL,
	[modified_by] [varchar](255) NULL,
	[modified_date] [datetime] NULL,
	[code] [varchar](255) NULL,
	[name] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[news]    Script Date: 2022/10/18 23:59:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[news](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[created_by] [varchar](255) NULL,
	[created_date] [datetime] NULL,
	[modified_by] [varchar](255) NULL,
	[modified_date] [datetime] NULL,
	[content] [varchar](255) NULL,
	[shortdescription] [varchar](255) NULL,
	[thumbnail] [varchar](255) NULL,
	[title] [varchar](255) NULL,
	[category_id] [numeric](19, 0) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[role]    Script Date: 2022/10/18 23:59:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[role](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[created_by] [varchar](255) NULL,
	[created_date] [datetime] NULL,
	[modified_by] [varchar](255) NULL,
	[modified_date] [datetime] NULL,
	[code] [varchar](255) NULL,
	[name] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[user]    Script Date: 2022/10/18 23:59:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[created_by] [varchar](255) NULL,
	[created_date] [datetime] NULL,
	[modified_by] [varchar](255) NULL,
	[modified_date] [datetime] NULL,
	[fullname] [varchar](255) NULL,
	[password] [varchar](255) NULL,
	[status] [int] NULL,
	[username] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[user_role]    Script Date: 2022/10/18 23:59:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user_role](
	[user_id] [numeric](19, 0) NOT NULL,
	[role_id] [numeric](19, 0) NOT NULL
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[category] ON 
GO
INSERT [dbo].[category] ([id], [created_by], [created_date], [modified_by], [modified_date], [code], [name]) VALUES (CAST(1 AS Numeric(19, 0)), NULL, NULL, NULL, NULL, N'the-thao', N'the thao')
GO
INSERT [dbo].[category] ([id], [created_by], [created_date], [modified_by], [modified_date], [code], [name]) VALUES (CAST(2 AS Numeric(19, 0)), NULL, NULL, NULL, NULL, N'chinh-tri', N'chinh tri')
GO
INSERT [dbo].[category] ([id], [created_by], [created_date], [modified_by], [modified_date], [code], [name]) VALUES (CAST(3 AS Numeric(19, 0)), NULL, NULL, NULL, NULL, N'khoa-hoc', N'khoa hoc')
GO
SET IDENTITY_INSERT [dbo].[category] OFF
GO
SET IDENTITY_INSERT [dbo].[news] ON 
GO
INSERT [dbo].[news] ([id], [created_by], [created_date], [modified_by], [modified_date], [content], [shortdescription], [thumbnail], [title], [category_id]) VALUES (CAST(1 AS Numeric(19, 0)), NULL, NULL, NULL, NULL, N'Khoa hoc spring boot', N'khoa hoc springboot', N'khoa hoc java', N'day la khoa hoc java springboot', CAST(3 AS Numeric(19, 0)))
GO
INSERT [dbo].[news] ([id], [created_by], [created_date], [modified_by], [modified_date], [content], [shortdescription], [thumbnail], [title], [category_id]) VALUES (CAST(2 AS Numeric(19, 0)), NULL, NULL, NULL, NULL, N'Bai 1: tao project java springboot', N'tao project springboot', NULL, NULL, CAST(1 AS Numeric(19, 0)))
GO
INSERT [dbo].[news] ([id], [created_by], [created_date], [modified_by], [modified_date], [content], [shortdescription], [thumbnail], [title], [category_id]) VALUES (CAST(3 AS Numeric(19, 0)), NULL, NULL, NULL, NULL, N'Bai 2: goi api springboot', N'goi api springboot', NULL, N'Khoa hoc java springboot', CAST(3 AS Numeric(19, 0)))
GO
INSERT [dbo].[news] ([id], [created_by], [created_date], [modified_by], [modified_date], [content], [shortdescription], [thumbnail], [title], [category_id]) VALUES (CAST(4 AS Numeric(19, 0)), NULL, NULL, NULL, NULL, N'Bai 6: them api springboot', N'them api springboot', NULL, N'Khoa hoc java springboot', CAST(3 AS Numeric(19, 0)))
GO
INSERT [dbo].[news] ([id], [created_by], [created_date], [modified_by], [modified_date], [content], [shortdescription], [thumbnail], [title], [category_id]) VALUES (CAST(5 AS Numeric(19, 0)), NULL, NULL, NULL, NULL, N'Bai 2: goi api springboot', N'goi api springboot', NULL, N'Khoa hoc java springboot', CAST(3 AS Numeric(19, 0)))
GO
SET IDENTITY_INSERT [dbo].[news] OFF
GO
ALTER TABLE [dbo].[news]  WITH CHECK ADD  CONSTRAINT [FKryugyuqj7jjkqd3byc5meoocy] FOREIGN KEY([category_id])
REFERENCES [dbo].[category] ([id])
GO
ALTER TABLE [dbo].[news] CHECK CONSTRAINT [FKryugyuqj7jjkqd3byc5meoocy]
GO
ALTER TABLE [dbo].[user_role]  WITH CHECK ADD  CONSTRAINT [FKa68196081fvovjhkek5m97n3y] FOREIGN KEY([role_id])
REFERENCES [dbo].[role] ([id])
GO
ALTER TABLE [dbo].[user_role] CHECK CONSTRAINT [FKa68196081fvovjhkek5m97n3y]
GO
ALTER TABLE [dbo].[user_role]  WITH CHECK ADD  CONSTRAINT [FKfgsgxvihks805qcq8sq26ab7c] FOREIGN KEY([user_id])
REFERENCES [dbo].[user] ([id])
GO
ALTER TABLE [dbo].[user_role] CHECK CONSTRAINT [FKfgsgxvihks805qcq8sq26ab7c]
GO
USE [master]
GO
ALTER DATABASE [springbootnews] SET  READ_WRITE 
GO
