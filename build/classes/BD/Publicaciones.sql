USE [master]
GO
CREATE DATABASE [Publicaciones]
GO
USE [Publicaciones]
GO

CREATE TABLE [dbo].[Revista](
	[numero] [int] IDENTITY(1,1) NOT NULL,
	[titulo] [varchar](150) NOT NULL,
	[ayo] [int] NULL,
	[issn] [varchar](30) NULL,
	[precio] [float] NOT NULL,
	[Horaventa] [time](7) NOT NULL,
 CONSTRAINT [PK_Revista] PRIMARY KEY CLUSTERED 
(
	[numero] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]